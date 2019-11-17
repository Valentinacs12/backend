package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.Budget;
import co.edu.unal.software_engineering.meetu.model.Plan;
import co.edu.unal.software_engineering.meetu.pojo.CreatePlanPOJO;
import co.edu.unal.software_engineering.meetu.repository.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository ){
        this.budgetRepository = budgetRepository;
    }

    public Budget findById(Integer id) {
        return budgetRepository.findById(id).orElse(null);
    }

    public Budget findByPlanId(String planId) {
        return budgetRepository.findByPlanId(planId);
    }

    public void save( Budget budget ){
        budgetRepository.save( budget );
    }

    //Quizas falta isRightBudget
}
