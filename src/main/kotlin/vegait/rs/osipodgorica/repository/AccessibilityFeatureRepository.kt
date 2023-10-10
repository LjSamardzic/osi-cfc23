package vegait.rs.osipodgorica.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vegait.rs.osipodgorica.model.AccessibilityFeature

@Repository
interface AccessibilityFeatureRepository: JpaRepository<AccessibilityFeature, Long> {
    fun findByName(name: String): AccessibilityFeature

    fun findAllByIdIn(ids: List<Long>): Set<AccessibilityFeature>
}