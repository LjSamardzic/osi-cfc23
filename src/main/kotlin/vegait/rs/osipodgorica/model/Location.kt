package vegait.rs.osipodgorica.model

import jakarta.persistence.*

@Entity
@Table(name = "locations")
class Location (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var description: String,
    var latitude: Double,
    var longitude: Double,
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    var category: Category,
    @ManyToMany
    @JoinTable(
        name= "accessibility_feature_location",
        joinColumns = arrayOf(JoinColumn(name = "location_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "accessibility_feature_id"))
    )
    var accessibilityFeatures: Set<AccessibilityFeature> = hashSetOf()
)

