import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

fun <T: Item> Route.libraryRoutes(service: IService<T>){
    get<Libraries> {
        if(!service.hasItems())
            call.respond(HttpStatusCode.NoContent, "No libraries found")
        else
            call.respond(service.getAllItems()!!)
    }
    get<Library> {
        val id = it.id ?: call.respond(HttpStatusCode.BadRequest, "No id error")
        val library = service.getItem(id as Int) ?: call.respond(HttpStatusCode.NotFound, "Library not found")
        call.respond(library)
    }
}