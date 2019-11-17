package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.Comment;
import co.edu.unal.software_engineering.meetu.repository.CommentRepository;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment findById(Integer id ){
        return commentRepository.findById( id ).orElse( null );
    }

    public Comment findByPlanId( String planId ){
        return commentRepository.findByPlanId(  planId );
    }
}
