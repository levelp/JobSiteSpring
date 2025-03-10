
package jobsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"jobsite"})
public class JobSiteSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSiteSpringApplication.class, args);
    }
}
