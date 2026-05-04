package io.shnflrsc.sparky.repository;

import io.shnflrsc.sparky.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM breeds ORDER BY RAND() LIMIT 1")
    Breed findRandomBreed();

    @Query(nativeQuery = true, value = "SELECT * FROM breeds ORDER BY RAND() LIMIT :count")
    List<Breed> findRandomBreeds(@Param("count") int count);
}
