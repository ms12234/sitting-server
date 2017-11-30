package com.sitting

import com.fasterxml.jackson.databind.ObjectMapper
import com.sitting.server.Measurement
import com.sitting.server.Position
import com.sitting.server.Sensor
import org.junit.Test
import java.util.*

class Test {
    @Test
    fun hello() {
        val serializer = ObjectMapper()

        val grades = mutableListOf<Sensor>()
        grades.add(Sensor(1F, 1F, Position.Bottom, 1.0))
        grades.add(Sensor(1F, 1F, Position.Bottom, 1.0))
        grades.add(Sensor(1F, 1F, Position.Bottom, 1.0))
        grades.add(Sensor(1F, 1F, Position.Bottom, 1.0))

        val measurement = Measurement(Date(), grades, 1.0F)
        val json = serializer.writerWithDefaultPrettyPrinter()
                .writeValueAsString(measurement)
        println(json)
    }
}