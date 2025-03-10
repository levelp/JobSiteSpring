
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

    @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/jobsite}")
    private String url;

    @Value("${spring.datasource.username:postgres}")
    private String username;

    @Value("${spring.datasource.password:postgres}")
    private String password;

    @Override
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring default PostgreSQL datasource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
public class DefaultDataSourceConfig implements DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDataSourceConfig.class);

    @Value("${spring.datasource.driver-class-name:org.postgresql.Driver}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username:#{null}}")
    private String username;

    @Value("${spring.datasource.password:#{null}}")
    private String password;

    @Override
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring PostgreSQL DataSource with URL: {}", url);
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        
        // Используем учетные данные, только если они предоставлены
        if (username != null && !username.isEmpty()) {
            dataSource.setUsername(username);
            logger.debug("Using provided username");
        }
        
        if (password != null && !password.isEmpty()) {
            dataSource.setPassword(password);
            logger.debug("Using provided password");
        }
        
        return dataSource;
    }
}
