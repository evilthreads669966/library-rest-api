data class Repository(override val source: IDataSource<AndroidLibrary> ): IRepository<AndroidLibrary> {
    override fun findItemById(id: Int) = source.items.find { it.id == id }

    override fun getAllItems(): Collection<AndroidLibrary> {
        return source.items
    }

    override fun hasItems(): Boolean {
        return source.items.isNotEmpty()
    }
}

interface IRepository<T: Item>{
    val source: IDataSource<T>
    fun findItemById(id: Int): T?
    fun getAllItems(): Collection<T>?
    fun hasItems(): Boolean
}