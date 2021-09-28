package com.kollu.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private String topic_1 = "kolluTopic";
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		kafkaTemplate.send(topic_1, "Hi i am "+name+" from Restcontroller");
		return "Data Published";
	}
	
	//get call
	
	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(123,"Bhardwaja",new String[] {"baluChow", "Hyd"});
		kafkaTemplate.send(topic_1, "JSON : "+user); 
		return "Data Published";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
