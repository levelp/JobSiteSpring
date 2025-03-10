
package jobsite.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public interface DataSourceConfig {
    DataSource dataSource();
}
