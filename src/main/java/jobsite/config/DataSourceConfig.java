
package jobsite.config;

import org.springframework.context.annotation.Configuration;

import jakarta.sql.DataSource;

@Configuration
public interface DataSourceConfig {
    DataSource dataSource();
}
