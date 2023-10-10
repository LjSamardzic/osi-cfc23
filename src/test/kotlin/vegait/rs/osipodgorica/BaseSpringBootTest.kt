package vegait.rs.osipodgorica

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
        classes = arrayOf(OsipodgoricaApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseSpringBootTest {

}
