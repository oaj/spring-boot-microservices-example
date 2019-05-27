package dk.amfibia.moviecatalogservice.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @RequestMapping("/who")
    public String sayHello() {
        return "Hello World";
    }

}
