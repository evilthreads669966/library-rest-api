package com.chrisbasinger

import AndroidLibrary
import com.google.gson.Gson
import io.kotest.assertions.ktor.shouldHaveContent
import io.kotest.assertions.ktor.shouldHaveStatus
import io.kotest.assertions.ktor.shouldNotHaveStatus
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test

/*this test won't run and I can't figure it out. It's not failing it just won't get picked up by the ide*/

class RouteTest {
    @Test
    fun testRoot() {
        val libraries = setOf(
            AndroidLibrary(0, "EvadeMe", "evilthreads669966", "https://github.com/evilthreads669966/evademe", "A Kotlin heuristics evasion library for Android."),
            AndroidLibrary(1, "Pickpocket", "evilthreads669966", "https://github.com/evilthreads669966/pickpocket", "A Kotlin library for Android with content provider queries and support for reactive streams and coroutines."),
            AndroidLibrary(2, "Bootlaces", "evilthreads669966", "https://github.com/evilthreads669966/bootlaces", "A Kotlin work manager library for Android with support for progress notifications and Hilt support."),
            AndroidLibrary(3, "Skimmer", "evilthreads669966", "https://github.com/evilthreads669966/skimmer", "A fast Kotlin keylogger library for Android."),
            AndroidLibrary(4, "Jackhammer", "evilthreads669966", "https://github.com/evilthreads669966/jackhammer", "A Kotlin brute force privilege escalation library for Android that wraps your code in a brute force permission request."),
            AndroidLibrary(5, "SmsBackdoor", "evilthreads669966", "https://github.com/evilthreads669966/smsbackdoor", " A Kotlin Android library that opens a persistent binary SMS backdoor with the ability to define your own remote command handler."),
        )
        val gson = Gson()

        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/api/libraries").apply {
                response shouldHaveContent gson.toJson(libraries)
                response shouldNotHaveStatus HttpStatusCode.NoContent
                response shouldHaveStatus HttpStatusCode.OK
            }
            handleRequest { uri = "/api/libraries/0" }.run {
                response shouldHaveContent gson.toJson(libraries.find { it.id == 0 })
                response shouldNotHaveStatus HttpStatusCode.BadRequest
                response shouldNotHaveStatus HttpStatusCode.NotFound
                response shouldHaveStatus HttpStatusCode.OK
            }
            handleRequest { uri = "/api/libraries/100" }.run {
                response shouldHaveContent "Library not found"
                response shouldNotHaveStatus HttpStatusCode.BadRequest
                response shouldNotHaveStatus  HttpStatusCode.OK
                response shouldHaveStatus  HttpStatusCode.NotFound
            }
        }
    }
}