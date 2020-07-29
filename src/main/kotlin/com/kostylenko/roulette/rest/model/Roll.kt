package com.kostylenko.roulette.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY

data class Roll(val userId: String,
                @JsonProperty(access = READ_ONLY) val cellDescription: String?) {
}