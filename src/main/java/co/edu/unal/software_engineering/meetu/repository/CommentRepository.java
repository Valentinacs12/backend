package co.edu.unal.software_engineering.meetu.repository;

import co.edu.unal.software_engineering.meetu.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    // Comment findByPlanId(Integer planId );
}
