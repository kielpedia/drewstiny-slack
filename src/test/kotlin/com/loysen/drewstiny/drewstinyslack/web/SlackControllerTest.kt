package com.loysen.drewstiny.drewstinyslack.web

import com.loysen.drewstiny.drewstinyslack.SlackRequest
import com.loysen.drewstiny.drewstinyslack.config.SlackProperties
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SlackControllerTest {

    @Autowired
    lateinit var controller: DrewstinySlackController

    @MockBean
    lateinit var slackProperties: SlackProperties

    @Test
    fun `handle a slack message`() {
        `when`(slackProperties.token).thenReturn("test")

        val request = SlackRequest(token = "test", text = "message", command = "drewstiny",
                channelName = "sourceChannel", responseUrl = "url")
        assertThat(controller.handleMessage(request).text, `is`("drewstiny message"))
    }

    @Test(expected = InvalidTokenException::class)
    fun `throw exception when token is invalid`() {
        val request = SlackRequest(token = "", text = "message", command = "drewstiny",
                channelName = "sourceChannel", responseUrl = "url")
        controller.handleMessage(request)
    }

}