package vegait.rs.osipodgorica.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
internal class ResourceWebConfiguration : WebMvcConfigurer {

    @Value("\${app.file.resource-location:file:uploads/}")
    private val resourceLocation: String? = null

    @Value("\${spring.mvc.static-path-pattern:/uploads/**}")
    private val resourceHandler: String? = null

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler(resourceHandler)
                .addResourceLocations(resourceLocation)
                .setCachePeriod(3600)
                .resourceChain(true)
    }
}
