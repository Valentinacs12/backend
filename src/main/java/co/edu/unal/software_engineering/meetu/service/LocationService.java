package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.Location;
import co.edu.unal.software_engineering.meetu.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Location findById(Integer id ){
        return locationRepository.findById( id ).orElse( null );
    }

    public Location findByPlanId( Integer planId ){
        return locationRepository.findByPlanId(  planId );
    }
}
