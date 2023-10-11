package vegait.rs.osipodgorica.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import vegait.rs.osipodgorica.dto.CreateCategoryRequest
import vegait.rs.osipodgorica.model.Category
import vegait.rs.osipodgorica.repository.CategoryRepository

@Service
@Transactional
class CategoryService(val categoryRepo: CategoryRepository, val uploadService: ImageUploadService) {

    fun store(request: CreateCategoryRequest): Category {
        val category = categoryRepo.save(Category(name = request.name))

        val imagePath = uploadService.store(request.thumbnail, "categories/" + category.id)
        category.relativeUrl = imagePath

        return categoryRepo.save(category)
    }

    fun get(id: Long): Category {
        return categoryRepo.findById(id).orElseThrow()
    }

    fun index(): List<Category> {
        return categoryRepo.findAll()
    }
}