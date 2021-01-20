import org.koin.dsl.module

val appModule = module{
    single { setOf<Item>(
        AndroidLibrary(0, "EvadeMe", "evilthreads669966", "https://github.com/evilthreads669966/evademe", "A Kotlin heuristics evasion library for Android."),
        AndroidLibrary(1, "Pickpocket", "evilthreads669966", "https://github.com/evilthreads669966/pickpocket", "A Kotlin library for Android with content provider queries and support for reactive streams and coroutines."),
        AndroidLibrary(2, "Bootlaces", "evilthreads669966", "https://github.com/evilthreads669966/bootlaces", "A Kotlin work manager library for Android with support for progress notifications and Hilt support."),
        AndroidLibrary(3, "Skimmer", "evilthreads669966", "https://github.com/evilthreads669966/skimmer", "A fast Kotlin keylogger library for Android."),
        AndroidLibrary(4, "Jackhammer", "evilthreads669966", "https://github.com/evilthreads669966/jackhammer", "A Kotlin brute force privilege escalation library for Android that wraps your code in a brute force permission request."),
        AndroidLibrary(5, "SmsBackdoor", "evilthreads669966", "https://github.com/evilthreads669966/smsbackdoor", " A Kotlin Android library that opens a persistent binary SMS backdoor with the ability to define your own remote command handler."),
        ) }
    single<IDataSource<AndroidLibrary>>{ DataSource(get()) }
    single<IRepository<AndroidLibrary>> { Repository(get()) }
    single<IService<AndroidLibrary>> { Service(get()) }
}