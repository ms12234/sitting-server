package com.sitting.server

import org.springframework.stereotype.Component

@Component
class PositionJudge {
    fun isCorrect(measurement: Measurement): Boolean {
        measurement.sensors.filter { it.value == 0.0 }
                .first { return false }

        return true
    }
}