package com.loysen.drewstiny.drewstinyslack.web

import com.loysen.drewstiny.drewstinyslack.SlackRequest
import com.loysen.drewstiny.drewstinyslack.SlackResponse
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DrewstinySlackController {

    companion object : KLogging()

    @Value("\${slack.token}")
    lateinit var token: String

    @PostMapping(value = "/", consumes = arrayOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
    fun handleMessage(@RequestBody slackRequest: SlackRequest): SlackResponse {
        val command = slackRequest.command
        logger.info { "received command $command" }

        if (token != slackRequest.token) {
            throw InvalidTokenException()
        }
        return SlackResponse(text = "$command ${slackRequest.text}")
    }
}