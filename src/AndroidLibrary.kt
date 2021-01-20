data class AndroidLibrary(
    override val id: Int,
    val name: String,
    val owner: String,
    val url: String,
    val description: String,
): Item

interface Item{
    val id: Int
}