data class DataSource(override val data: Set<AndroidLibrary>) : IDataSource<AndroidLibrary>

interface IDataSource<T: Item>{
    val data: Collection<T>
}