package az.iktlab.groupj4web.service.impl;

import az.iktlab.groupj4web.dao.entity.CardEntity;
import az.iktlab.groupj4web.dao.repository.CardRepository;
import az.iktlab.groupj4web.model.CardDto;
import az.iktlab.groupj4web.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(CardDto dto) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCardId(dto.getCardId());

        repository.save(cardEntity);
    }

    @Override
    public CardDto getById(Long id) {
        CardEntity cardEntity = repository.getCardEntityById(id)
                .orElseThrow(() -> new RuntimeException("Id not founded"));

        CardDto dto = new CardDto();
        dto.setCardId(cardEntity.getCardId());

        return dto;
    }

    @Override
    public List<CardDto> getAll() {
        List<CardEntity> cards = repository.getAll();

        return cards.stream()
                .map(cardEntity -> new CardDto(cardEntity.getCardId()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(CardDto dto, Long id) {

        CardEntity cardEntity = repository.findByIdCustom(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        cardEntity.setCardId(dto.getCardId());

        repository.save(cardEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
