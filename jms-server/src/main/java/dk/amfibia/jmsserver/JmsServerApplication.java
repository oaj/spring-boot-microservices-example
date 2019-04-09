package dk.amfibia.jmsserver;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JmsServerApplication {

	@Bean
	public BrokerService broker() throws Exception {
		final BrokerService broker = new BrokerService();
		broker.addConnector("tcp://localhost:61616");
		broker.addConnector("vm://localhost");
		broker.setPersistent(false);
		return broker;
	}

	public static void main(String[] args) {
		SpringApplication.run(JmsServerApplication.class, args);
	}

}
