package com.demo.sampler2dbc.sample.repository

import com.demo.sampler2dbc.sample.Sample
import org.springframework.data.repository.kotlin.CoroutineSortingRepository

interface CustomCoroutineRepository : CoroutineSortingRepository<Sample, Long> {
}
