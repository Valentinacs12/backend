package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.PossibleDate;
import co.edu.unal.software_engineering.meetu.repository.PossibleDateRepository;
import org.springframework.stereotype.Service;


@Service
public class PossibleDateService {

    private final PossibleDateRepository possibleDateRepository;

    public PossibleDateService(PossibleDateRepository possibleDateRepository){
        this.possibleDateRepository = possibleDateRepository;
    }

    public PossibleDate findById(Integer id ){
        return possibleDateRepository.findById( id ).orElse( null );
    }

    /*
    public PossibleDate findByPlanId(Integer planId) {
        return possibleDateRepository.findByPlanId(  planId );
    }
*/

    public void save( PossibleDate possibleDate ){
        possibleDateRepository.save( possibleDate );
    }
}
