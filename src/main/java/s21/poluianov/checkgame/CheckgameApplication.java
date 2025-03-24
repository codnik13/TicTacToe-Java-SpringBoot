package s21.poluianov.checkgame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CheckgameApplication {

	public static void main(String[] args) {
		/*SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Playground playground = new Playground();
			}
		});*/
		//SpringApplication.run(CheckgameApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CheckgameApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}
}
