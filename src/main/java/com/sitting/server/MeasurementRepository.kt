package com.sitting.server

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

import java.time.LocalDateTime

@Repository
interface MeasurementRepository : MongoRepository<Measurement, String> {
    fun findByTimeBetween(begin: LocalDateTime, end: LocalDateTime): List<Measurement>
}
