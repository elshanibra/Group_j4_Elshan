package az.iktlab.groupj4web.service;

import az.iktlab.groupj4web.model.PersonDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonService {
     void add( PersonDto dto);


     PersonDto findById( Long id);

     List<PersonDto> getAll();


     void update(PersonDto dto, Long id);

     void deleteById(Long id);
}
