package az.iktlab.groupj4web.controller;

import az.iktlab.groupj4web.model.Hello;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/v2")
public class HelloWorldControllerV2 {

    @GetMapping
    public String getJson(@RequestParam Long id,
                          @RequestParam String name) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Hello hello = new Hello(id, name);

        String json = mapper.writeValueAsString(hello);

        return json;
    }
}
