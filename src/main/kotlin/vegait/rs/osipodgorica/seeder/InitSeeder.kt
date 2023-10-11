package vegait.rs.osipodgorica.seeder

import org.springframework.boot.CommandLineRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import vegait.rs.osipodgorica.model.AccessibilityFeature
import vegait.rs.osipodgorica.model.Location
import vegait.rs.osipodgorica.model.Category
import vegait.rs.osipodgorica.repository.AccessibilityFeatureRepository
import vegait.rs.osipodgorica.repository.CategoryRepository
import vegait.rs.osipodgorica.repository.LocationRepository

@Component
class InitSeeder(
    val featuresRepo: AccessibilityFeatureRepository,
    val categoryRepo: CategoryRepository,
    val locationRepo: LocationRepository,
    val env: Environment
): CommandLineRunner {

    override fun run(vararg args: String?) {
        if (featuresRepo.count() == 0L) {
            featuresRepo.saveAll(features())
        }

        if (categoryRepo.count() == 0L) {
            categoryRepo.saveAll(categories())
        }

        if (env.activeProfiles.contains("dev") && locationRepo.count() == 0L) {
            locationRepo.saveAll(locations())
        }
    }

    private fun features(): List<AccessibilityFeature> {
        return arrayListOf(
            AccessibilityFeature(name = "Rampa"),
            AccessibilityFeature(name = "Taktilna crta vodilja"),
            AccessibilityFeature(name = "Lift"),
            AccessibilityFeature(name = "Ulazni prostor"),
            AccessibilityFeature(name = "Toalet"),
            AccessibilityFeature(name = "Kupatilo"),
            AccessibilityFeature(name = "Ulaz u vodu na plaži i bazenu"),
            AccessibilityFeature(name = "Mjesto u gledalištu"),
            AccessibilityFeature(name = "Šalter"),
            AccessibilityFeature(name = "Pult"),
            AccessibilityFeature(name = "Induktivna petlja ili transmisioni obruč"),
            AccessibilityFeature(name = "Oglasni pano"),
            AccessibilityFeature(name = "Orjentacioni plan za kretanje u objektu"),
            AccessibilityFeature(name = "Stajalište i peron"),
            AccessibilityFeature(name = "Parking mjesto"),
            AccessibilityFeature(name = "Semafor"),
            AccessibilityFeature(name = "Pješački prelazi"),
            AccessibilityFeature(name = "Raskrsnica")
        )
    }

    private fun categories(): List<Category> {
        return arrayListOf(
          Category(id = 1, name = "Objekti državnih organa", relativeUrl = "/uploads/categories/1/image.jpg"),
          Category(id = 2, name = "Lokalna samouprava", relativeUrl = "/uploads/categories/2/image.jpg"),
          Category(id = 3, name = "Zdravstvo", relativeUrl = "/uploads/categories/3/image.jpg"),
          Category(id = 4, name = "Obrazovanje", relativeUrl = "/uploads/categories/4/image.jpg"),
          Category(id = 5, name = "Kultura", relativeUrl = "/uploads/categories/5/image.jpg"),
          Category(id = 6, name = "Otvoreni i zatvoreni sportski i rekreativni objekti", relativeUrl = "/uploads/categories/6/image.jpg"),
          Category(id = 7, name = "Saobraćajni terminali", relativeUrl = "/uploads/categories/7/image.jpg"),
          Category(id = 8, name = "Pošte", relativeUrl = "/uploads/categories/8/image.jpg"),
          Category(id = 9, name = "Ostalo", relativeUrl = "/uploads/categories/9/image.jpg"),
        )
    }

    private fun locations(): List<Location> {
        val publicFacility = categoryRepo.findByName("Objekti državnih organa")
        val culturalFacility = categoryRepo.findByName("Kultura")
        val hospital = categoryRepo.findByName("Obrazovanje")
        val parking = featuresRepo.findByName("Parking mjesto")
        val ramp = featuresRepo.findByName("Rampa")
        val loo = featuresRepo.findByName("Toalet")

        return arrayListOf(
            Location(
                name = "KBC",
                description = "Kliničko bolnički centar CG",
                category = hospital,
                accessibilityFeatures = hashSetOf(parking, loo),
                latitude = 42.437966,
                longitude = 19.246028
            ),
            Location(
                name = "KIC Budo Tomović",
                description = "Kulturni objekat",
                category = culturalFacility,
                accessibilityFeatures = hashSetOf(loo),
                latitude = 42.446105,
                longitude = 19.264439
            ),
            Location(
                name = "MUP",
                description = "Ministarstvo unutrašnjih poslova",
                category = publicFacility,
                accessibilityFeatures = hashSetOf(ramp),
                latitude = 42.442171,
                longitude = 19.252682
            )
        )
    }
}