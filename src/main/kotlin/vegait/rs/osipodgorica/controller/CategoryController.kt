package vegait.rs.osipodgorica.controller

import org.springframework.web.bind.annotation.*
import vegait.rs.osipodgorica.dto.CreateCategoryRequest
import vegait.rs.osipodgorica.model.Category
import vegait.rs.osipodgorica.service.CategoryService

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(val categoryService: CategoryService) {

    @PostMapping
    fun store(@RequestBody request: CreateCategoryRequest): Category {
        return categoryService.store(request)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id : Long): Category {
        return categoryService.get(id)
    }

    @GetMapping
    fun index(): List<Category> {
        return categoryService.index()
    }
}