/*
package com.chrisbasinger

import AndroidLibrary
import IService
import Item
import appModule
import io.kotest.core.script.describe
import io.kotest.core.spec.style.FunSpec
import io.kotest.koin.KoinListener
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.koin.test.KoinTest
import org.koin.test.inject


*/
/*These tests aren't compiling so they don't work right now*//*

class KoinTest:  FunSpec(), KoinTest{
    lateinit var libraries: Collection<AndroidLibrary>

    override fun listeners() = listOf(KoinListener(appModule))

    val service: IService<Item> by inject()

    init {
        beforeTest {
            libraries = setOf(
                AndroidLibrary(0, "EvadeMe", "evilthreads669966", "https://github.com/evilthreads669966/evademe", "A Kotlin heuristics evasion library for Android."),
                AndroidLibrary(1, "Pickpocket", "evilthreads669966", "https://github.com/evilthreads669966/pickpocket", "A Kotlin library for Android with content provider queries and support for reactive streams and coroutines."),
                AndroidLibrary(2, "Bootlaces", "evilthreads669966", "https://github.com/evilthreads669966/bootlaces", "A Kotlin work manager library for Android with support for progress notifications and Hilt support."),
                AndroidLibrary(3, "Skimmer", "evilthreads669966", "https://github.com/evilthreads669966/skimmer", "A fast Kotlin keylogger library for Android."),
                AndroidLibrary(4, "Jackhammer", "evilthreads669966", "https://github.com/evilthreads669966/jackhammer", "A Kotlin brute force privilege escalation library for Android that wraps your code in a brute force permission request."),
                AndroidLibrary(5, "SmsBackdoor", "evilthreads669966", "https://github.com/evilthreads669966/smsbackdoor", " A Kotlin Android library that opens a persistent binary SMS backdoor with the ability to define your own remote command handler."),
            )
        }

        test("test libraries with service"){
            describe("get all libraries with service"){
                it("getAllItems should not return null"){
                    service.getAllItems() shouldNotBe null
                }
                it("getAllItems should return a collection with the same size as libraries"){
                    service.getAllItems()!! shouldBeSameSizeAs libraries
                }
                it("get all items should return same collection with same items as libraries"){
                    service.getAllItems()!! shouldBe libraries
                }
                it("getAllItems should contain libraries"){
                    service.getAllItems()!! shouldContainAll libraries
                }
                it("getAllItems should not contain any null items"){
                    service.getAllItems()!! shouldNotContain null
                }
                it("hasItems should return false"){
                    service.hasItems() shouldBeEqualComparingTo  true
                }
            }
        }
        test("test library with service"){
            describe("get one library with service by id"){
                it("should return a library that is not null"){
                    service.getItem(0) shouldNotBe  null
                }
                it("should return library with id of 0"){
                    val library = service.getItem(0)
                    library!!.id shouldBe 0
                }
                it("should return a library in libraries"){
                    libraries shouldContain service.getItem(0)
                }
                it("should return null"){
                    service.getItem(666) shouldBe  null
                }
                it("libraries should contain a library with id of 0"){
                    libraries shouldContain service.getItem(0)
                }
            }
        }
    }
}*/
