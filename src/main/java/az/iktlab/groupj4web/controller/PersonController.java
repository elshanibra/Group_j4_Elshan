package az.iktlab.groupj4web.controller;

import az.iktlab.groupj4web.model.PersonDto;
import az.iktlab.groupj4web.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    public void add(@RequestBody PersonDto dto) {
        personService.add(dto);

    }

    @GetMapping("/id")
    public PersonDto findById(@PathVariable Long id) {
        return personService.findById(id);


    }

    @GetMapping
    public List<PersonDto> getAll() {
      return   personService.getAll();

    }

    @PutMapping
    public void update(@RequestBody PersonDto dto,@PathVariable Long id) {
        personService.update(dto,id);

    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        personService.deleteById(id);

    }


}
