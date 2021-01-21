package com.chrisbasinger

import AndroidLibrary
import com.google.gson.Gson
import io.kotest.assertions.ktor.*
import io.kotest.core.script.describe
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.*
import io.ktor.server.testing.*

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

    test("test content negotiation and headers"){
        withTestApplication({ module(testing = true) }) {
            describe("responses should match installed features in application"){
                handleRequest(HttpMethod.Get, "/api/").run {
                    it("should return json content") {
                        response.shouldHaveContentType(ContentType.Application.Json)
                    }
                    it("should have ktor server header"){
                        response.shouldHaveHeader("X-Engine", "Ktor")
                    }
                }
            }
        }
    }

    test("test get request for all libraries"){
        withTestApplication({ module(testing = true) }) {
            describe("test response for request for libraries") {
                handleRequest(HttpMethod.Get, "/api/libraries").run {
                    it("Should return serialized collection of all libraries"){
                        response shouldHaveContent gson.toJson(libraries)
                    }
                    it("Should not have 204 response code"){
                        response shouldNotHaveStatus HttpStatusCode.NoContent
                    }
                    it("Should have http response code of 200"){
                        response shouldHaveStatus HttpStatusCode.OK
                    }
                }
            }
        }
    }

    test("test handling get request for a library"){
        withTestApplication({ module(testing = true) }) {
            describe("test response for request for a library by id") {
                handleRequest(HttpMethod.Get, "/api/libraries/0").run {
                    it("should return json content"){
                        response.shouldHaveContentType(ContentType.Application.Json)
                    }
                    it("Should return library a with an id of 0"){
                        response shouldHaveContent gson.toJson(libraries.find { it.id == 0 })
                    }
                    it("Should not have 404 response code"){
                        response shouldNotHaveStatus HttpStatusCode.NotFound
                    }
                    it("Should have http response code of 200"){
                        response shouldHaveStatus HttpStatusCode.OK
                    }
                }
            }
        }
    }

    test("test handling get request for a library that does not exist"){
        withTestApplication({ module(testing = true) }) {
            describe("test response for request for a library that is not in storage") {
                handleRequest(HttpMethod.Get, "/api/libraries/100").run {
                    it("should return json content"){
                        response.shouldHaveContentType(ContentType.Application.Json)
                    }
                    it("Should return not found message"){
                        response shouldHaveContent "Library not found"
                    }
                    it("Should not return http response code of 400"){
                        response shouldNotHaveStatus HttpStatusCode.BadRequest
                    }
                    it("Should not return http response code of 200"){
                        response shouldNotHaveStatus  HttpStatusCode.OK
                    }
                    it("Should return http response code of 404"){
                        response shouldHaveStatus  HttpStatusCode.NotFound
                    }
                }
            }
        }
    }
})