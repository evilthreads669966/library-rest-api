data class DataSource(override val items: List<AndroidLibrary>) : IDataSource<AndroidLibrary>

interface IDataSource<T: Item>{
    val items: Collection<T>
}