package vegait.rs.osipodgorica.service

import org.springframework.stereotype.Service
import vegait.rs.osipodgorica.dto.CreateCategoryRequest
import vegait.rs.osipodgorica.model.Category
import vegait.rs.osipodgorica.repository.CategoryRepository

@Service
class CategoryService(val categoryRepo: CategoryRepository) {

    fun store(request: CreateCategoryRequest): Category {
        val category = Category(name = request.name)
        return categoryRepo.save(category)
    }

    fun get(id: Long): Category {
        return categoryRepo.findById(id).orElseThrow()
    }

    fun index(): List<Category> {
        return categoryRepo.findAll()
    }
}