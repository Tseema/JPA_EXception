package com.relearn.rest.webservices.restwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//restApI
@RestController
public class HelloWorldController {

    private MessageSource msgSources;

    public HelloWorldController(MessageSource msgSources){
        this.msgSources = msgSources;
    }

    @GetMapping(path = "/hello-world")
    public String helloworld(){
        return "Hello WOrld";
    }

  /*  @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloworld(){
        return new HelloWorldBean("Hello WOrld bean");
    }*/

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBeanJ helloWorldBean(){
        return new HelloWorldBeanJ("Hello world bean");
    }

    @GetMapping(path ="/hello-world-pathvariable/{name}")
    public HelloWorldPathVariable helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldPathVariable("hello world " + name);
    }

    @GetMapping(path = "/hello-world-international")
    public String helloworldinternational(){
        Locale locale = LocaleContextHolder.getLocale();
        return msgSources.getMessage("good.morning.message",null,"Default only ya",locale);
        //return "Hello WOrld v2";
    }

}
