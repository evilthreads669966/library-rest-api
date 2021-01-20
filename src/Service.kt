data class Service(override val repository: IRepository<AndroidLibrary>) : IService<AndroidLibrary> {
    override fun getItem(id: Int): AndroidLibrary? {
        return repository.findItemById(id)
    }

    override fun getAllItems(): Collection<AndroidLibrary>? {
        return repository.getAllItems()
    }

    override fun hasItems(): Boolean {
        return repository.hasItems()
    }
}

interface IService<T: Item>{
    val repository: IRepository<T>
    fun getItem(id: Int): T?
    fun getAllItems(): Collection<T>?
    fun hasItems(): Boolean
}