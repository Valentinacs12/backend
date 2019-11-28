package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.Budget;
import co.edu.unal.software_engineering.meetu.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    public void save( Budget budget ){
        budgetRepository.save( budget );
    }

}
