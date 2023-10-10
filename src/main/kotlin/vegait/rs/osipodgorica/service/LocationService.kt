package vegait.rs.osipodgorica.service

import com.blazebit.persistence.CriteriaBuilderFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import vegait.rs.osipodgorica.dto.CreateLocationRequest
import vegait.rs.osipodgorica.dto.UpdateLocationRequest
import vegait.rs.osipodgorica.model.Category
import vegait.rs.osipodgorica.model.Location
import vegait.rs.osipodgorica.repository.AccessibilityFeatureRepository
import vegait.rs.osipodgorica.repository.CategoryRepository
import vegait.rs.osipodgorica.repository.LocationRepository
import vegait.rs.osipodgorica.utils.LocationQueryBuilder

@Service
class LocationService(
    val repository: LocationRepository,
    val categoryRepo: CategoryRepository,
    val featureRepo: AccessibilityFeatureRepository,
    val entityManager: EntityManager,
    val criteriaBuilderFactory: CriteriaBuilderFactory
) {

    fun store(request: CreateLocationRequest) : Location {
        val category: Category = categoryRepo.findById(request.categoryId).orElseThrow()
        val features = featureRepo.findAllByIdIn(request.accessibilityFeatureIds)
        val location = Location(
            name = request.name,
            description = request.description,
            category = category,
            accessibilityFeatures = features,
            latitude = request.latitude,
            longitude = request.longitude
        )

        return repository.save(location)
    }

    fun get(id: Long): Location {
        return repository.findById(id).orElseThrow()
    }

    fun index(categoryId: Long?, featureIds: List<Long>?): List<Location> {
        return LocationQueryBuilder(criteriaBuilderFactory, entityManager)
            .accessibilityFeatures(featureIds)
            .category(categoryId)
            .build()
    }

    fun delete(id: Long) {
        return repository.deleteById(id)
    }

    fun update(request: UpdateLocationRequest, id: Long): Location {
        val existingLocation = repository.findById(id).orElseThrow()
        val category: Category = categoryRepo.findById(request.categoryId).orElseThrow()
        val features = featureRepo.findAllByIdIn(request.accessibilityFeatureIds)

        existingLocation.name = request.name
        existingLocation.description = request.description
        existingLocation.category = category
        existingLocation.latitude = request.latitude
        existingLocation.longitude = request.longitude
        existingLocation.accessibilityFeatures = features

        return repository.save(existingLocation)
    }
}