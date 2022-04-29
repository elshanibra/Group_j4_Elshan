package az.iktlab.groupj4web.service.impl;

import az.iktlab.groupj4web.dao.entity.PersonEntity;
import az.iktlab.groupj4web.dao.repository.PersonRepository;

import az.iktlab.groupj4web.model.PersonDto;
import az.iktlab.groupj4web.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void add(PersonDto dto) {
        PersonEntity personEntity  =new PersonEntity();
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setAge(dto.getAge());
        personEntity.setGender(dto.getGender());

        personRepository.save(personEntity);

    }

    @Override
    public PersonDto findById(Long id) {
        PersonEntity personEntity=personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not founded"));
        PersonDto dto=new PersonDto();
        dto.setAge(personEntity.getAge());
        dto.setName(personEntity.getName());
        dto.setSurname(personEntity.getSurname());
        dto.setGender(personEntity.getGender());


        return dto;
    }

    @Override
    public List<PersonDto> getAll() {
        List<PersonEntity> persons = (List<PersonEntity>) personRepository.findAll();

        return persons.stream()
                .map(personEntity -> new PersonDto(personEntity.getName(),personEntity.getSurname(),
                        personEntity.getAge(),personEntity.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(PersonDto dto,Long id) {



        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setAge(dto.getAge());
        personEntity.setGender(dto.getGender());

        personRepository.save(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);

    }
}
