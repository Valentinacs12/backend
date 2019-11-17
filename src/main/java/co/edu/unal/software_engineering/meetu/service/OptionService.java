package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.Option;
import co.edu.unal.software_engineering.meetu.model.PossibleDate;
import co.edu.unal.software_engineering.meetu.repository.OptionRepository;
import co.edu.unal.software_engineering.meetu.repository.PossibleDateRepository;
import org.springframework.stereotype.Service;


@Service
public class OptionService {

    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository){
        this.optionRepository = optionRepository;
    }

    public Option findById(Integer id ){
        return optionRepository.findById( id ).orElse( null );
    }

    public Option findByPlanId( String planId ){
        return optionRepository.findByPlanId(  planId );
    }

    public void save( Option option ){
        optionRepository.save( option );
    }
}
