package com.loysen.drewstiny.drewstinyslack.web

import com.loysen.drewstiny.drewstinyslack.SlackRequest
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.util.ReflectionTestUtils

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SlackControllerTest {

    @Autowired
    lateinit var controller: DrewstinySlackController

    @Test
    fun `handle a slack message`() {
        ReflectionTestUtils.setField(controller, "token",  "test")

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