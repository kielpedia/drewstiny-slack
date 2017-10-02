package com.loysen.drewstiny.drewstinyslack

data class SlackResponse(val text: String)

data class SlackRequest(val token: String, val channelName: String, var responseUrl: String, val text: String,
                        val command: String)