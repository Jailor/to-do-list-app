package andrei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@Slf4j
public class TodoListApplication extends SpringBootServletInitializer {

	// JSTL stuff
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoListApplication.class);
	}
	public static void main(String[] args) {
		log.info("todo list application started");
		SpringApplication.run(TodoListApplication.class, args);
	}

}
