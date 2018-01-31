package com.sitting.server

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@SpringBootTest
@RunWith(SpringRunner::class)
class ControllerTest {
    @Autowired
    private lateinit var repository: MeasurementRepository

    @Test
    fun test() {
        repository.deleteAll()

        val list = mutableListOf<Sensor>()
        for (i in 0..8) {
            list.add(Sensor(0F, 0F, Position.Back, 0.0))
        }

        for (i in 0..10) {
            repository.save(Measurement(null, Date(), list, 0.0F))
            Thread.sleep((700 - i).toLong())
        }

        val all = repository.findAll()
    }
}