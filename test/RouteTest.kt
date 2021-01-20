package com.chrisbasinger

import AndroidLibrary
import com.google.gson.Gson
import io.kotest.assertions.ktor.shouldHaveContent
import io.kotest.assertions.ktor.shouldHaveStatus
import io.kotest.assertions.ktor.shouldNotHaveStatus
import io.kotest.core.script.describe
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import io.ktor.server.testing.*

/*this test won't run and I can't figure it out. It's not failing it just won't get picked up by the ide*/

class RouteTest: FunSpec({
    lateinit var libraries: Collection<AndroidLibrary>
    lateinit var gson: Gson

    beforeTest {
        libraries = setOf(
            AndroidLibrary(0, "EvadeMe", "evilthreads669966", "https://github.com/evilthreads669966/evademe", "A Kotlin heuristics evasion library for Android."),
            AndroidLibrary(1, "Pickpocket", "evilthreads669966", "https://github.com/evilthreads669966/pickpocket", "A Kotlin library for Android with content provider queries and support for reactive streams and coroutines."),
            AndroidLibrary(2, "Bootlaces", "evilthreads669966", "https://github.com/evilthreads669966/bootlaces", "A Kotlin work manager library for Android with support for progress notifications and Hilt support."),
            AndroidLibrary(3, "Skimmer", "evilthreads669966", "https://github.com/evilthreads669966/skimmer", "A fast Kotlin keylogger library for Android."),
            AndroidLibrary(4, "Jackhammer", "evilthreads669966", "https://github.com/evilthreads669966/jackhammer", "A Kotlin brute force privilege escalation library for Android that wraps your code in a brute force permission request."),
            AndroidLibrary(5, "SmsBackdoor", "evilthreads669966", "https://github.com/evilthreads669966/smsbackdoor", " A Kotlin Android library that opens a persistent binary SMS backdoor with the ability to define your own remote command handler."),
        )
        gson = Gson()
    }

    test("Should return proper response codes and content for routes"){
        withTestApplication({ module(testing = true) }) {
            describe("Should return libraries in json format and a 200 response code"){
                handleRequest(HttpMethod.Get, "/api/libraries").run {
                    response shouldHaveContent gson.toJson(libraries)
                    response shouldNotHaveStatus HttpStatusCode.NoContent
                    response shouldHaveStatus HttpStatusCode.OK
                }
            }
            describe("Should return first library in collection in json format and a 200 response code"){
                handleRequest { uri = "/api/libraries/0" }.run {
                    response shouldHaveContent gson.toJson(libraries.find { it.id == 0 })
                    response shouldNotHaveStatus HttpStatusCode.BadRequest
                    response shouldNotHaveStatus HttpStatusCode.NotFound
                    response shouldHaveStatus HttpStatusCode.OK
                }
            }
            describe("Should return library not found and 404 response code when parameter is larger that collection size"){
                handleRequest { uri = "/api/libraries/100" }.run {
                    response shouldHaveContent "Library not found"
                    response shouldNotHaveStatus HttpStatusCode.BadRequest
                    response shouldNotHaveStatus  HttpStatusCode.OK
                    response shouldHaveStatus  HttpStatusCode.NotFound
                }
            }
        }
    }
})