package com.sitting.server

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.logging.Logger

@RequestMapping(path = arrayOf("measurement"),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
@RestController
class Controller(private val measurementRepository: MeasurementRepository) {
    
    private val logger = Logger.getLogger(javaClass.simpleName)

    @PostMapping
    fun postMeasurement(measurement: Measurement): ResponseEntity<*> {
        try {
            measurementRepository!!.save(measurement)
            return ResponseEntity(HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

    }

    @GetMapping
    fun getMeasurements(
            @RequestParam(value = "begin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            begin: LocalDateTime,

            @RequestParam(value = "end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            end: LocalDateTime): ResponseEntity<List<Measurement>> {

        return ResponseEntity(
                measurementRepository!!.findByTimeBetween(begin, end), HttpStatus.OK)
    }
}
