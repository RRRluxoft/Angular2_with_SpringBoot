package home.investigation.rrr.fullstackappangularspringboot.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("home.investigation.rrr.fullstackappangularspringboot.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
