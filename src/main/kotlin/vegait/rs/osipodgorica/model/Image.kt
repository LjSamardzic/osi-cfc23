package vegait.rs.osipodgorica.model

import jakarta.persistence.*
import org.hibernate.annotations.Any
import org.hibernate.annotations.AnyDiscriminator
import org.hibernate.annotations.AnyDiscriminatorValue
import org.hibernate.annotations.AnyKeyJavaClass
import vegait.rs.osipodgorica.interfaces.HasImages
import vegait.rs.osipodgorica.model.Location

@Entity
@Table(name = "images")
class Image(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var relativeUrl: String,

        @Any
//        @AnyDiscriminator(DiscriminatorType.STRING)
//        @AnyDiscriminatorValue(discriminator = "location", entity = Location::class)
//        @AnyKeyJavaClass(Long.class)
        @JoinColumn(name = "entity_id")
        @Column(name = "entity_type")
        var imageable: HasImages
)