package az.iktlab.groupj4web.controller;

import az.iktlab.groupj4web.model.Hello;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public Hello hello() {
        return new Hello(1L, "Khayal");
    }

    @PostMapping("/write/{v2}")
    public void postEx(@RequestParam(name = "value") String value,
                       @RequestParam(name = "val2") String value2,
                       @PathVariable String v2,
                       @RequestHeader("h1") String h) {
        System.out.println(h);
        System.out.println(value2);
        System.out.println(value);
        System.out.println(v2);
    }

    @PutMapping
    public void putEx() {
        System.out.println("Put mapping example");
    }

    @PatchMapping
    public void patchEx() {
        System.out.println("Patch mapping example");
    }

    @DeleteMapping
    public void deleteEx() {
        System.out.println("Delete mapping example");
    }
}