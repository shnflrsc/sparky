package io.shnflrsc.sparky.repository;

import io.shnflrsc.sparky.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM names ORDER BY RAND() LIMIT 1")
    Name findRandomName();

    @Query(nativeQuery = true, value = "SELECT * FROM names ORDER BY RAND() LIMIT :count")
    List<Name> findRandomNames(@Param("count") int count);
}
