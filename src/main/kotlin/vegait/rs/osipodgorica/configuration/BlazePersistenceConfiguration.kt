package vegait.rs.osipodgorica.configuration

import com.blazebit.persistence.Criteria
import com.blazebit.persistence.CriteriaBuilderFactory
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.PersistenceUnit
import lombok.NoArgsConstructor
import lombok.NonNull
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Scope

@Configuration
@RequiredArgsConstructor
@NoArgsConstructor
class BlazePersistenceConfiguration(
) {
    @PersistenceUnit
    private lateinit var entityManagerFactory: EntityManagerFactory

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy(false)
    fun createCriteriaBuilderFactory(): CriteriaBuilderFactory {
        val config = Criteria.getDefault()
        return config.createCriteriaBuilderFactory(entityManagerFactory)

//        https://thorben-janssen.com/create-better-criteria-queries-with-blaze-persistence/
    }
}