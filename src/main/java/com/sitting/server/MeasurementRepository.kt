package com.sitting.server

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MeasurementRepository : MongoRepository<Measurement, String> {
    fun findByTimeBetween(begin: Date, end: Date): List<Measurement>
}
