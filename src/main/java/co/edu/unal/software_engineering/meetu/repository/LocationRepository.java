package co.edu.unal.software_engineering.meetu.repository;

import co.edu.unal.software_engineering.meetu.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
