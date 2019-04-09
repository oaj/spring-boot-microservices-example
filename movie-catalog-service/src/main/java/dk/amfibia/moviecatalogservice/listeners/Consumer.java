package dk.amfibia.moviecatalogservice.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination="test.queue")
    private void listen(String message) {
        System.out.println("Catalog - Consumed: " + message);
    }
}
