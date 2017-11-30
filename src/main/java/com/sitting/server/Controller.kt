package com.sitting.server

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import java.util.logging.Logger


@RequestMapping(path = ["measurement"],
        consumes = [(MediaType.APPLICATION_JSON_UTF8_VALUE)],
        produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
@RestController
class Controller(private val measurementRepository: MeasurementRepository,
                 private val positionJudge: PositionJudge) {

    private val logger = Logger.getLogger(javaClass.simpleName)

    @PostMapping
    fun save(@RequestBody measurement: Measurement): ResponseEntity<Any> {
        try {
            positionJudge.isCorrect(measurement)
        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        measurementRepository.save(measurement)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping
    fun get(
            @RequestParam(value = "begin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            begin: LocalDateTime,

            @RequestParam(value = "end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            end: LocalDateTime): ResponseEntity<List<Measurement>> {


        val beginConverted = Date.from(begin.toInstant(ZoneOffset.UTC))
        val endConverted = Date.from(end.toInstant(ZoneOffset.UTC))

        return ResponseEntity(measurementRepository.
                findByTimeBetween(beginConverted, endConverted), HttpStatus.OK)
    }
}

