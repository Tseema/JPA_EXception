package com.relearn.rest.webservices.restwebservices.helloworld;

public class HelloWorldPathVariable {
    String name;

    public HelloWorldPathVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloWorldPathVariable{" +
                "name='" + name + '\'' +
                '}';
    }
}
