package com.demo.sampler2dbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.repository.RepositoryDefinition
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@ConfigurationPropertiesScan("com.demo.sampler2dbc.config")
@SpringBootApplication
class SampleR2dbcApplication

fun main(args: Array<String>) {
    runApplication<SampleR2dbcApplication>(*args)
}
