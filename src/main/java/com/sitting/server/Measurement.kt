package com.sitting.server

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Measurement(@Id @Indexed var id: String?,
                       @JsonFormat(pattern =
                       "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+1") var time:
                       Date,
                       var sensors: List<Sensor>,
                       var grade: Float) {
}
