package dk.amfibia.residencialcatalogservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ResidencialCatalogServiceApplication


@Bean
@LoadBalanced
fun getRestTemplate(): RestTemplate {
	return RestTemplate()
}

fun main(args: Array<String>) {
	runApplication<ResidencialCatalogServiceApplication>(*args)
}
