package com.demo.sampler2dbc.sample.service

import com.demo.sampler2dbc.sample.GetSampleListRes

interface SampleService {
    suspend fun list(sampleId: Long): GetSampleListRes
}