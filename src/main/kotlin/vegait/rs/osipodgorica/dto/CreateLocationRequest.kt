package vegait.rs.osipodgorica.dto

data class CreateLocationRequest(
    val name: String,
    val description: String,
    val categoryId: Long,
    val accessibilityFeatureIds: List<Long>,
    val latitude: Double,
    val longitude: Double
)
