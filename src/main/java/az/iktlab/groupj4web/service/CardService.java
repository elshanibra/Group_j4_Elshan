package az.iktlab.groupj4web.service;

import az.iktlab.groupj4web.model.CardDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CardService {

    void add(CardDto dto);

    CardDto getById(Long id);

    List<CardDto> getAll();

    void update(CardDto dto, Long id);

    void deleteById(Long id);
}