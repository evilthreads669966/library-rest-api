import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun <T: Item> Route.libraryRoutes(service: IService<T>){
    get<Libraries> {
        if(!service.hasItems())
            call.respond(HttpStatusCode.NoContent, "No libraries found")
        else
            call.respond(service.getAllItems()!!)
    }
    get<Library> { library ->
        library.id ?: call.respond(HttpStatusCode.BadRequest, "No id error")
        val library = service.getItem(library.id as Int)!! ?: call.respond(HttpStatusCode.NotFound, "Library not found")
        call.respond(library)
    }
}