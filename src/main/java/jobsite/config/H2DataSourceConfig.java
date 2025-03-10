
package jobsite.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Profile("h2")
public class H2DataSourceConfig implements DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(H2DataSourceConfig.class);

    @Override
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring H2 in-memory database");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("jobsite")
                .build();
    }
}
