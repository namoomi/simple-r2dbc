package com.demo.sampler2dbc.config.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties(prefix = "spring.r2dbc")
data class R2dbcProps(
    val url: String,
    val username: String,
    val password: String,
    val name: String
)