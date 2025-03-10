
package jobsite.config;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
    
    @Value("${spring.datasource.driver-class-name:org.postgresql.Driver}")
    private String driverClassName;
    
    @Value("${spring.datasource.url:jdbc:postgresql://localhost:5432/jobsite}")
    private String url;
    
    @Value("${spring.datasource.username:postgres}")
    private String username;
    
    @Value("${spring.datasource.password:postgres}")
    private String password;
    
    @Override
    @Bean
    public DataSource dataSource() {
        logger.info("Configuring default database connection");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
