package com.chrisbasinger

import AndroidLibrary
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.kotest.assertions.ktor.*
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import io.ktor.server.testing.*

class RouteTest: FunSpec({
    lateinit var libraries: Collection<AndroidLibrary>
    lateinit var gson: Gson
    lateinit var contentType: ContentType
    beforeTest {
        libraries = setOf(
            AndroidLibrary(0, "EvadeMe", "evilthreads669966", "https://github.com/evilthreads669966/evademe", "A Kotlin heuristics evasion library for Android."),
            AndroidLibrary(1, "Pickpocket", "evilthreads669966", "https://github.com/evilthreads669966/pickpocket", "A Kotlin library for Android with content provider queries and support for reactive streams and coroutines."),
            AndroidLibrary(2, "Bootlaces", "evilthreads669966", "https://github.com/evilthreads669966/bootlaces", "A Kotlin work manager library for Android with support for progress notifications and Hilt support."),
            AndroidLibrary(3, "Skimmer", "evilthreads669966", "https://github.com/evilthreads669966/skimmer", "A fast Kotlin keylogger library for Android."),
            AndroidLibrary(4, "Jackhammer", "evilthreads669966", "https://github.com/evilthreads669966/jackhammer", "A Kotlin brute force privilege escalation library for Android that wraps your code in a brute force permission request."),
            AndroidLibrary(5, "SmsBackdoor", "evilthreads669966", "https://github.com/evilthreads669966/smsbackdoor", " A Kotlin Android library that opens a persistent binary SMS backdoor with the ability to define your own remote command handler."),
        )
        gson = GsonBuilder().setPrettyPrinting().create()
        contentType = ContentType.parse("application/json; charset=UTF-8")
    }

    test("test get request for all libraries"){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/api/libraries").run {
                response.shouldHaveContentType(contentType)
                response.shouldHaveHeader("X-Engine", "Ktor")
                response shouldHaveContent gson.toJson(libraries)
                response shouldNotHaveStatus HttpStatusCode.NoContent
                response shouldHaveStatus HttpStatusCode.OK
            }
        }
    }

    test("test handling get request for a library"){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/api/libraries/0").run {
                response.shouldHaveContentType(contentType)
                response.shouldHaveHeader("X-Engine", "Ktor")
                response shouldHaveContent gson.toJson(libraries.find { it.id == 0 })
                response shouldNotHaveStatus HttpStatusCode.NotFound
                response shouldHaveStatus HttpStatusCode.OK
            }
        }
    }

    /*this test is failing saying that we have already sent a response*/
    test("test handling get request for a library that does not exist"){
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/api/libraries/100").run {
                response.shouldHaveContentType(contentType)
                response.shouldHaveHeader("X-Engine", "Ktor")
                response shouldHaveContent "Library not found"
                response shouldNotHaveStatus HttpStatusCode.BadRequest
                response shouldNotHaveStatus  HttpStatusCode.OK
                response shouldHaveStatus  HttpStatusCode.NotFound
            }
        }
    }
})