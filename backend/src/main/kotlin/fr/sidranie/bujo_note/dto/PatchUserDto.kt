package fr.sidranie.bujo_note.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class PatchUserDto(
    @JsonProperty("id")
    val id: UUID,
    @JsonProperty("username")
    val username: String?,
    @JsonProperty("givenName")
    val givenName: String?,
    @JsonProperty("familyName")
    val familyName: String?,
    @JsonProperty("password")
    val password: String?,
    @JsonProperty("email")
    val email: String?
)
