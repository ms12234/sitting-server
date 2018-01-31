package com.sitting.server

import org.springframework.stereotype.Component

@Component
class PositionJudge {
    fun isCorrect(measurement: Measurement): Float {


        val mes = measurement.sensors
        if (mes[2].value == 1.0 && mes[6].value == 1.0 && mes[7].value == 1.0) {
            return 1.0F
        } else {
            return 0.0F
        }
    }
}