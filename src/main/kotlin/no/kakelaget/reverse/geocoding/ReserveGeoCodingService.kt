package no.kakelaget.reverse.geocoding

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import java.util.*
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod

@Service
class ReserveGeoCodingService  {

    companion object {
        val logger: Logger = LogManager.getLogger(ReserveGeoCodingService::class.java.name)
    }

    fun isInsideOslo(lon: Double, lat: Double) : Boolean {
        val url = String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s", lat, lon)
        logger.info("url: $url");
        val restTemplate: RestTemplate = RestTemplate()
        val headers: HttpHeaders = HttpHeaders()
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
        val entity = HttpEntity("parameters", headers)
        val response = restTemplate.exchange(url, HttpMethod.GET, entity, Place::class.java)
        val place = response.body
        if(place?.address == null) return false
        return place.address.county == "Oslo"
    }
}