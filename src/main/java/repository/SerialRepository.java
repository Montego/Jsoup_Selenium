package repository;
import entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerialRepository extends JpaRepository<Serial, Long> {
    Serial findByNameRus(String name_rus);

    Serial findByNameEng(String name_eng);

    Serial findByRate(Float rate);

    List<Serial> findAll();
}