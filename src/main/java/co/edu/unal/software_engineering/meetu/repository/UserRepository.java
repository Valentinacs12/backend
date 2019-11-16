package co.edu.unal.software_engineering.meetu.repository;

import co.edu.unal.software_engineering.meetu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername( String username );

}
