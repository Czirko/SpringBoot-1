package hu.czirko.SpringBoot_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
@GetMapping("hello-wolrd")
    public String helloWorld(){
    return "Hello Wolrd";
}
@GetMapping(path = "/getHelloBean")
    public HelloWorldBean helloWorldBean(){
    return new HelloWorldBean("Hello Wolrd");
}

@GetMapping(path = "/hellowithpathvar/{name}")
    public HelloWorldBean getWithPathParam(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello %s",name));

}

}
