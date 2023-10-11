//package vegait.rs.osipodgorica.integration
//
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.web.client.TestRestTemplate
//import vegait.rs.osipodgorica.BaseSpringBootTest
//import vegait.rs.osipodgorica.model.Location
//
//
//class ExampleTest : BaseSpringBootTest() {
//
//    @Autowired
//    lateinit var restTemplate: TestRestTemplate
//
//    @Test
//    fun testICanStoreALocation() {
//
//        val locationRequest = Location(name = "MUP", description = "Rampa na ulazu")
//
//        val location: Location = restTemplate.postForObject("/api/v1/locations", locationRequest, Location::class.java)
//
//        assertThat(location).isNotNull()
//        assertThat(location.name).isEqualTo(locationRequest.name)
//        assertThat(location.description).isEqualTo(locationRequest.description)
//    }
//
//}
