
package jobsite.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Profile("default")
public class DefaultDataSourceConfig implements DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataSourceConfig.class);

    @Value("${spring.datasource.url:jdbc:h2:mem:jobsite}")
    private String url;

    @Value("${spring.datasource.username:sa}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;

    @Override
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring default datasource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
