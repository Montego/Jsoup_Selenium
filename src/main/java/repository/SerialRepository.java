package repository;


import entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerialRepository extends JpaRepository<Serial, Long> {
    //Serial findByName_rus(String name_rus);

    //Serial findByName_eng(String name_eng);

    Serial findByRate(Float rate);

    List<Serial> findAll();
}