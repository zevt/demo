package com.example.demo;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }


  @RestController
  class controllers {
    @GetMapping("/**")
    public ResponseEntity<?> getAll(HttpServletRequest request) {
      ObjectNode node = JsonNodeFactory.instance.objectNode();
      node.put("url", request.getRequestURI());
      return new ResponseEntity<>(node, HttpStatus.OK);
    }
  }

}
