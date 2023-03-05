package cz.upce.cv01.controller;

//?1)
//@Controller - vraci HTTP response
//@RestController - pro REST API, vrací JSON

//?2)
// JSON
//{
//  "myInfo": {
//    "firstName": "Sumeet"
//  }
//}
// YAML
//  myInfo:
//      firstName:Jmeno
//  XML - <myInfo><firstName>Jmeno</firstName></myInfo>

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1") //-> application.properties
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/path/{message}")
    public String helloPath(@PathVariable String message){
        //localhost:9000/api/v1/path/ahoj
        return "Message from path variable: " + message;
    }

    @GetMapping("/query")
    public String helloQuery(@RequestParam(name = "id") String message){
        //localhost:9000/api/v1/query?id=ahoj
        //id -> message default
        return "Message from query variable: " + message;
    }

    @GetMapping("/body")
    public String helloRequestBody(@RequestBody SimpleBody body){
        //localhost:9000/api/v1/
        return "Message from body: " + body.toString();
    }
}
