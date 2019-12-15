package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.*;
import co.edu.unal.software_engineering.meetu.pojo.CreatePlanPOJO;
import co.edu.unal.software_engineering.meetu.repository.PlanRepository;
//import co.edu.unal.software_engineering.meetu.service.BudgetService;
import co.edu.unal.software_engineering.meetu.service.PlanService;
import co.edu.unal.software_engineering.meetu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import co.edu.unal.software_engineering.meetu.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class PlanController {

    private final PlanService planService;
    private final UserService userService;

    public PlanController(PlanService planService, UserService userService) {
        this.planService = planService;
        this.userService = userService;
    }

    @Autowired
    private PlanRepository planRepository;

    @PostMapping( value = { "/plan/" } )
    public ResponseEntity register(@RequestBody CreatePlanPOJO planPOJO ){
        String email = SecurityContextHolder.getContext( ).getAuthentication( ).getName();
        Plan newPlan = new Plan();
        User existingUser = userService.findByEmail( email );
        newPlan.setDescription(planPOJO.getDescription());
        newPlan.setTitle(planPOJO.getTitle());
        // newPlan.setBudgets(planPOJO.getBudgets());
        planService.save(newPlan);

        List<Budget> listBudgets = planPOJO.getBudgets();
        List<Budget> ltbg = new ArrayList<Budget>();
        for (Budget budget : listBudgets) {
            Budget newBudget = new Budget();
            newBudget.setMoney(budget.getMoney());
            newBudget.setPlan(newPlan);
            ltbg.add(newBudget);
            // newPlan.addBudget(newBudget);
        }
        newPlan.setBudgets(ltbg);
        planService.save(newPlan);



        List<Comment> listComments = planPOJO.getComments();
        List<Comment> ltcmm = new ArrayList<Comment>();
        for (Comment comment : listComments) {
            Comment newComment = new Comment();
            newComment.setCommentary(comment.getCommentary());
            newComment.setPlan(newPlan);
            ltcmm.add(newComment);
            // newPlan.addBudget(newBudget);
        }
        newPlan.setComments(ltcmm);
        planService.save(newPlan);


        List<Location> listLocations = planPOJO.getLocations();
        List<Location> ltlc = new ArrayList<Location>();
        for (Location location : listLocations) {
            Location newLocation = new Location();
            newLocation.setName(location.getName());
            newLocation.setPlan(newPlan);
            ltlc.add(newLocation);
            // newPlan.addBudget(newBudget);
        }
        newPlan.setLocations(ltlc);
        planService.save(newPlan);


        List<Option> listOptions = planPOJO.getOptions();
        List<Option> lto = new ArrayList<Option>();
        for (Option option : listOptions) {
            Option newOption = new Option();
            newOption.setName(option.getName());
            newOption.setPlan(newPlan);
            lto.add(newOption);
            // newPlan.addBudget(newBudget);
        }
        newPlan.setOptions(lto);
        planService.save(newPlan);


        List<PossibleDate> listDates = planPOJO.getDates();
        List<PossibleDate> ltpd = new ArrayList<PossibleDate>();
        for (PossibleDate date : listDates) {
            PossibleDate newDate = new PossibleDate();
            newDate.setStart_date(date.getStart_date());
            newDate.setEnd_date(date.getEnd_date());
            newDate.setPlan(newPlan);
            ltpd.add(newDate);
            // newPlan.addBudget(newBudget);
        }
        newPlan.setDates(ltpd);
        List<User> users = new ArrayList<User>();
        users.add(existingUser);
        newPlan.setUsers(users);

        planService.save(newPlan);

        return new ResponseEntity( HttpStatus.CREATED );
    }


    @GetMapping(value = {"/consultaplan/{planId}"}) //Get plan
    public Plan getPlan(@PathVariable Integer planId) {
        Plan temp = planService.findById(planId);
        return temp;
    }


    @PutMapping( value = {"consultaplan/{planId}"} ) //Update plan --------- NOT WORKING
    public ResponseEntity updatePlan( @PathVariable Integer planId, @RequestBody CreatePlanPOJO planPOJO) {

        Plan temp = getPlan(planId);
        temp.setTitle(planPOJO.getTitle());
        temp.setDescription(planPOJO.getDescription());

        List<Budget> listBudgets = planPOJO.getBudgets();
        List<Budget> ltbg = new ArrayList<Budget>();
        for (Budget budget : listBudgets) {
            Budget newBudget = new Budget();
            newBudget.setMoney(budget.getMoney());
            newBudget.setPlan(temp);
            ltbg.add(newBudget);
        }
        temp.setBudgets(ltbg);

        List<Comment> listComments = planPOJO.getComments();
        List<Comment> ltcmm = new ArrayList<Comment>();
        for (Comment comment : listComments) {
            Comment newComment = new Comment();
            newComment.setCommentary(comment.getCommentary());
            newComment.setPlan(temp);
            ltcmm.add(newComment);
        }
        temp.setComments(ltcmm);

        List<Location> listLocations = planPOJO.getLocations();
        List<Location> ltlc = new ArrayList<Location>();
        for (Location location : listLocations) {
            Location newLocation = new Location();
            newLocation.setName(location.getName());
            newLocation.setPlan(temp);
            ltlc.add(newLocation);
        }
        temp.setLocations(ltlc);

        List<Option> listOptions = planPOJO.getOptions();
        List<Option> lto = new ArrayList<Option>();
        for (Option option : listOptions) {
            Option newOption = new Option();
            newOption.setName(option.getName());
            newOption.setPlan(temp);
            lto.add(newOption);
        }
        temp.setOptions(lto);

        List<PossibleDate> listDates = planPOJO.getDates();
        List<PossibleDate> ltpd = new ArrayList<PossibleDate>();
        for (PossibleDate date : listDates) {
            PossibleDate newDate = new PossibleDate();
            newDate.setStart_date(date.getStart_date());
            newDate.setEnd_date(date.getEnd_date());
            newDate.setPlan(temp);
            ltpd.add(newDate);
        }
        temp.setDates(ltpd);

        planService.save(temp);

        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping(value = {"consultaplan/{planId}"})   //delete plan
    public ResponseEntity<?> deletePlan(@PathVariable Integer planId) {
        return planRepository.findById(planId)
                .map(plan -> {
                    planRepository.delete(plan);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Plan not found with id " + planId));
    }


}