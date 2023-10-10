package vegait.rs.osipodgorica.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vegait.rs.osipodgorica.model.Location

@Repository
interface LocationRepository: JpaRepository<Location, Long>