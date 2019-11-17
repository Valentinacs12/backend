package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.Budget;
import co.edu.unal.software_engineering.meetu.model.Plan;
import co.edu.unal.software_engineering.meetu.pojo.CreatePlanPOJO;
import co.edu.unal.software_engineering.meetu.service.BudgetService;
import co.edu.unal.software_engineering.meetu.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class PlanController {

    private final PlanService planService;
    // private final BudgetService budgetService;

    public PlanController(PlanService planService, BudgetService budgetService){
        this.planService = planService;
       // this.budgetService = budgetService;
    }


    @PostMapping( value = { "/plan" } )

    public ResponseEntity register(@RequestBody CreatePlanPOJO planPOJO ){

        Plan newPlan = new Plan();

        newPlan.setDescription(planPOJO.getDescription());
        newPlan.setTitle(planPOJO.getTitle());
        // newPlan.setIdPlan(22);
        newPlan.setBudgets(planPOJO.getBudgets());
        planService.save(newPlan);
        //   Plan temp = planService.findById(2);
        /*
        List<Budget> listBudgets = planPOJO.getBudgets();
        for (Budget budget: listBudgets) {
            Budget newBudget = new Budget();
            newBudget.setMoney(budget.getMoney());
            newBudget.setPlan(newPlan);
            budgetService.save(newBudget);
           // newPlan.addBudget(newBudget);
        }

         */

        return new ResponseEntity( HttpStatus.CREATED );
    }


    @GetMapping( value = { "/consultaplan/{planId}" } )
    public Plan register( @PathVariable Integer planId){
        Plan temp = planService.findById(planId);
        return temp;
    }
}