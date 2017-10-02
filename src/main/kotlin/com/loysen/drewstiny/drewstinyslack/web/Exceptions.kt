package com.loysen.drewstiny.drewstinyslack.web

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN)
class InvalidTokenException : Exception()