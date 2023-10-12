package vegait.rs.osipodgorica.model

import jakarta.persistence.*

@Entity
@Table(name = "categories")
class Category (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var relativeUrl: String? = null
)