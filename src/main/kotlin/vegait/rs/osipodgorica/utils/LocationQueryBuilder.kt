package vegait.rs.osipodgorica.utils

import com.blazebit.persistence.CriteriaBuilder
import com.blazebit.persistence.CriteriaBuilderFactory
import jakarta.persistence.EntityManager
import vegait.rs.osipodgorica.model.AccessibilityFeature
import vegait.rs.osipodgorica.model.Location

class LocationQueryBuilder(
    private val builderFactory: CriteriaBuilderFactory,
    private val entityManager: EntityManager,
    private val criteriaBuilder: CriteriaBuilder<Location> = builderFactory.create(entityManager, Location::class.java, "location")
    ) {
    fun accessibilityFeatures(featureIds: List<Long>?): LocationQueryBuilder {
        if (featureIds.isNullOrEmpty()) {
            return this
        }

        val subQuery = builderFactory.create(entityManager, Long::class.java)
            .from(AccessibilityFeature::class.java)
            .select("id")
            .where("id").
            `in`(featureIds)

        criteriaBuilder.whereExists()
            .from(Location::class.java, "l")
            .leftJoin("l.accessibilityFeatures", "af")
            .where("af.id").`in`(subQuery)
            .where("l.id").eqExpression("location.id")
            .end()
            .end()

        return this
    }

    fun category(categoryId: Long?): LocationQueryBuilder {
        if (categoryId == null) {
            return this
        }

        criteriaBuilder.where("location.category.id").eq(categoryId)

        return this
    }

    fun build(): List<Location> {
        return this.criteriaBuilder.resultList
    }
}