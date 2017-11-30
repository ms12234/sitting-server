package com.sitting.server

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Measurement(@Id @Indexed var time: Date,
                       var sensors: List<Sensor>,
                       var grade: Float) {

    constructor() : this(Date(), emptyList(), 0F)
}
