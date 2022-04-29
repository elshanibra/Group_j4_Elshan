package az.iktlab.groupj4web.dao.repository;

import az.iktlab.groupj4web.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Long> {

    Optional<CardEntity> getCardEntityById(Long id);

    @Query(value = "select * from group_j4.card", nativeQuery = true)
    List<CardEntity> getAll();


    @Query(value = "select * from group_j4.card where id =:id", nativeQuery = true)
    Optional<CardEntity> findByIdCustom(@Param("id") Long id);
}