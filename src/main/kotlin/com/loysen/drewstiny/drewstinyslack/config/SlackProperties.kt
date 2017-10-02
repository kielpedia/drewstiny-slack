package com.loysen.drewstiny.drewstinyslack.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "slack")
data class SlackProperties(var token: String?)