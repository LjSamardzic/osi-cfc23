package vegait.rs.osipodgorica.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vegait.rs.osipodgorica.model.Category

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {
    fun findByName(name: String): Category
}