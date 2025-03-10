
package jobsite.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface DataSourceConfig {
    DataSource dataSource();
}
package jobsite.config;

import javax.sql.DataSource;

public interface DataSourceConfig {
    DataSource dataSource();
}
