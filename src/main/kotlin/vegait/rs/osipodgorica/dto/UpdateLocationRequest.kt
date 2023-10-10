package vegait.rs.osipodgorica.dto

data class UpdateLocationRequest(
    val name: String,
    val description: String,
    val categoryId: Long,
    val accessibilityFeatureIds: List<Long>,
    val latitude: Double,
    val longitude: Double
)
