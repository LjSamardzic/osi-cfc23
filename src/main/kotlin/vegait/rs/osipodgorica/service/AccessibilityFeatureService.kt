package vegait.rs.osipodgorica.service

import org.springframework.stereotype.Service
import vegait.rs.osipodgorica.dto.CreateAccessibilityFeature
import vegait.rs.osipodgorica.model.AccessibilityFeature
import vegait.rs.osipodgorica.repository.AccessibilityFeatureRepository

@Service
class AccessibilityFeatureService(val featureRepo: AccessibilityFeatureRepository) {

    fun store(request: CreateAccessibilityFeature): AccessibilityFeature {
        val feature = AccessibilityFeature(name = request.name)
        return featureRepo.save(feature)
    }

    fun get(id: Long): AccessibilityFeature {
        return featureRepo.findById(id).orElseThrow()
    }

    fun index(): List<AccessibilityFeature> {
        return featureRepo.findAll()
    }
}