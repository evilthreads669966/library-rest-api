/*
data class Repository(private val source: DataSource){
    fun findById(id: Int) = source.androidLibraries.find { it.id == id }
    fun getAll(): Set<AndroidLibrary> = source.androidLibraries
    fun isEmpty() = source.androidLibraries.isEmpty()
}
*/

data class Repository(override val source: IDataSource<AndroidLibrary> ): IRepository<AndroidLibrary> {
    override fun findItemById(id: Int) = source.data.find { it.id == id }

    override fun getAllItems(): Collection<AndroidLibrary> {
        return source.data
    }

    override fun hasItems(): Boolean {
        return source.data.isNotEmpty()
    }
}

interface IRepository<T: Item>{
    val source: IDataSource<T>
    fun findItemById(id: Int): T?
    fun getAllItems(): Collection<T>?
    fun hasItems(): Boolean
}