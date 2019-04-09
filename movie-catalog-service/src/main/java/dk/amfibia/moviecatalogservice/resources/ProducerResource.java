package dk.amfibia.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    private final JmsTemplate jmsTemplate;

    @Autowired
    private final Queue queue;

    @Autowired
    public ProducerResource(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    @GetMapping("/{message}")
    String publish(@PathVariable("message") final String message) {

        jmsTemplate.convertAndSend(queue, message);
        return "Published: " + message;
    }

}
