package practicas2.homebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// un bean es una instancia de una clase con metadata. El bean entonces es un objeto que el
// "SpringContainer" esta manejando para nosotros
@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext context = SpringApplication.run(HomebankingApplication.class, args);
		SpringApplication.run(HomebankingApplication.class, args);

		// aca lo tengo que castear porque sino me tira error
		//SaludoBienvenida buenas = (SaludoBienvenida) context.getBean("buenas");



	}

}
