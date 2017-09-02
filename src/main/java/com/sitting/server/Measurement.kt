package com.sitting.server

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Measurement(@Id @Indexed var time: LocalDateTime,
                       var sensors: List<Sensor>) {

    constructor() : this(LocalDateTime.now(), emptyList())
}
