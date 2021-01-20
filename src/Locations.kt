import io.ktor.locations.*

@Location("/api/libraries")
class Libraries

@Location("/api/libraries/{id}")
data class Library(val id: Int?)