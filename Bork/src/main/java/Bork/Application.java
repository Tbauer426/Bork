package Bork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@EnableWebMvc
//@Configuration
//@ComponentScan
@SpringBootApplication
public class Application /* extends RepositoryRestMvcConfiguration */ {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}
}