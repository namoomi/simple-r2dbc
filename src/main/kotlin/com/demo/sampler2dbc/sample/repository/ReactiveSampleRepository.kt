package com.demo.sampler2dbc.sample.repository

import com.demo.sampler2dbc.sample.Sample
import org.springframework.data.r2dbc.repository.R2dbcRepository


interface ReactiveSampleRepository : R2dbcRepository<Sample, Long> {
    suspend fun findAllByName(name: String): List<Sample>
}



