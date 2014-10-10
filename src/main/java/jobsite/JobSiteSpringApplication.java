package jobsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "jobsite")
// Keep scanning broad to pick up entities/repositories across the project.
@EntityScan(basePackages = "jobsite")
@EnableJpaRepositories(basePackages = "jobsite")
@EnableMongoRepositories(basePackages = "jobsite")
public class JobSiteSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobSiteSpringApplication.class, args);
    }
}
