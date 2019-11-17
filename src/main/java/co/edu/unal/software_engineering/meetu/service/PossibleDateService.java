package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.PossibleDate;
import co.edu.unal.software_engineering.meetu.model.Role;
import co.edu.unal.software_engineering.meetu.repository.PossibleDateRepository;
import co.edu.unal.software_engineering.meetu.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PossibleDateService {

    private final PossibleDateRepository possibleDateRepository;

    public PossibleDateService(PossibleDateRepository possibleDateRepository){
        this.possibleDateRepository = possibleDateRepository;
    }

    public PossibleDate findById(Integer id ){
        return possibleDateRepository.findById( id ).orElse( null );
    }

    public PossibleDate findByPlanId( String planId ){
        return possibleDateRepository.findByPlanId(  planId );
    }

    public void save( PossibleDate possibleDate ){
        possibleDateRepository.save( possibleDate );
    }
}
