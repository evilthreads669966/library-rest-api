data class DataSource(override val items: Set<AndroidLibrary>) : IDataSource<AndroidLibrary>

interface IDataSource<T: Item>{
    val items: Collection<T>
}