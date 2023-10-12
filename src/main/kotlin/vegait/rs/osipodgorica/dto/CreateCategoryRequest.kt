package vegait.rs.osipodgorica.dto

import org.springframework.web.multipart.MultipartFile

data class CreateCategoryRequest(
    val name: String,
    val thumbnail: MultipartFile
)
