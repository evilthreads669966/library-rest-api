/*
package com.chrisbasinger

import AndroidLibrary
import IService
import Item
import appModule
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
            service.getAllItems() shouldNotBe null
            service.getAllItems()!! shouldBeSameSizeAs libraries
            service.getAllItems()!! shouldBe libraries
            service.getAllItems()!! shouldContainAll libraries
            service.getAllItems()!! shouldNotContain null
            service.hasItems() shouldBeEqualComparingTo  true
        }
        test("test library with service"){
            service.getItem(0) shouldNotBe  null
            val library = service.getItem(0)
            library!!.id shouldBe 0
            libraries shouldContain service.getItem(0)
            service.getItem(666) shouldBe  null
            libraries shouldContain service.getItem(0)
        }
    }
}
*/
