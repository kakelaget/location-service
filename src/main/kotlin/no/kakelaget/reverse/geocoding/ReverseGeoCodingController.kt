package no.kakelaget.reverse.geocoding

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ReverseGeoCodingController(private val reverseGeoCodingService: ReserveGeoCodingService) {
    @GetMapping("/point-in-oslo/lon/{lon}/lat/{lat}")
    fun isInOslo(@PathVariable(value = "lon") lon: Double, @PathVariable(value = "lat") lat: Double) : Boolean = reverseGeoCodingService.isInsideOslo(lon, lat)

    @GetMapping("/healthcheck")
    fun healtcheck() : ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}