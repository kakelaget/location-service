package no.kakelaget.reverse.geocoding

import java.io.Serializable

data class Place (val place_id: String, val lat: String, val lon: String, val address: Address) : Serializable