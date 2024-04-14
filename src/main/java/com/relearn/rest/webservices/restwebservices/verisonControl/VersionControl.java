package com.relearn.rest.webservices.restwebservices.verisonControl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionControl {

    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){

        return new  PersonV1("Seema T");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){

        return new  PersonV2(new Name("seema","Ti"));
    }


    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestPara(){

        return new  PersonV1("Seema T");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getFirstVersionOfPersonRequestParav2(){

        return new  PersonV2(new Name("seema","Ti"));
    }


    @GetMapping(path = "/header", headers = "x-api-version=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){

        return new  PersonV1("Seema T");
    }

    @GetMapping(path = "/header", headers = "x-api-version=2")
    public PersonV2 getSecondtVersionOfPersonRequestHeader(){

        return new  PersonV2(new Name("seema","Ti"));
    }

    @GetMapping(path ="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonaccepttHeader(){

        return new  PersonV1("Seema T");
    }

    @GetMapping(path ="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getsecondVersionOfPersonaccepttHeader(){

        return new  PersonV2(new Name("seema","Ti"));
    }
}
