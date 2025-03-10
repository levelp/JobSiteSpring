
package jobsite.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("default")
public class DefaultDataSourceConfig implements DataSourceConfig {

    @Value("${dataSource.driverClassName:org.postgresql.Driver}")
    private String driver;

    @Value("${dataSource.url:jdbc:postgresql://localhost:5432/jobsite}")
    private String url;

    @Value("${dataSource.username:postgres}")
    private String username;

    @Value("${dataSource.password:postgres}")
    private String password;

    @Override
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
