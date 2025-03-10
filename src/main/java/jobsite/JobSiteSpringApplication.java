
package jobsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan(basePackages = "jobsite.domain")
@EnableJpaRepositories(basePackages = "jobsite.repository")
@EnableMongoRepositories(basePackages = "jobsite.repository.mongo")
@ComponentScan(basePackages = "jobsite")
public class JobSiteSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobSiteSpringApplication.class, args);
    }
}
