package dk.amfibia.residencialcatalogservice.resource

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HelloResource {

    @RequestMapping("hello")
    fun hello(): String { return "Hello"}

}
