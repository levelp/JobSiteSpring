
package jobsite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "jobsite.repository")
public class MongoConfig {
    // Spring Boot auto-configuration will handle the MongoDB setup
    // based on application.properties
}
