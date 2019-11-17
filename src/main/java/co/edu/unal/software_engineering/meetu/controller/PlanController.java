package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.Budget;
import co.edu.unal.software_engineering.meetu.model.Plan;
import co.edu.unal.software_engineering.meetu.model.Role;
import co.edu.unal.software_engineering.meetu.model.User;
import co.edu.unal.software_engineering.meetu.pojo.CreatePlanPOJO;
import co.edu.unal.software_engineering.meetu.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.meetu.service.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@CrossOrigin
@RestController
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService){
        this.planService = planService;
    }


    @PostMapping( value = { "/plan" } )

    public ResponseEntity register(@RequestBody CreatePlanPOJO planPOJO ){

        Plan newPlan = new Plan();
        newPlan.setDescription(planPOJO.getDescription());
        newPlan.setTitle(planPOJO.getTitle());
        planService.save(newPlan);
/*
        List<Budget> listBudgets = planPOJO.getBudgets();
        for (Budget budget: listBudgets) {
            newPlan.addBudget(budget);
            budget.get
        }
*/
        return new ResponseEntity( HttpStatus.CREATED );

    }


}