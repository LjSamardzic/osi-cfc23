package vegait.rs.osipodgorica.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import vegait.rs.osipodgorica.dto.CreateLocationRequest
import vegait.rs.osipodgorica.dto.UpdateLocationRequest
import vegait.rs.osipodgorica.model.Location
import vegait.rs.osipodgorica.service.LocationService

@RestController
@RequestMapping("/api/v1/locations")
class LocationController(
    val service: LocationService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestBody request : CreateLocationRequest): Location {
       return service.store(request)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun get(@PathVariable id: Long): Location {
        return service.get(id)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam(name = "categoryId", required = false) categoryId: Long?,
              @RequestParam(name = "featureIds", required = false) featureIds: List<Long>?): List<Location> {

        return service.index(categoryId, featureIds)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        return service.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody request: UpdateLocationRequest, @PathVariable id: Long): Location {
        return service.update(request, id)
    }
}
