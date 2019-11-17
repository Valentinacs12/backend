package co.edu.unal.software_engineering.meetu.pojo;

import co.edu.unal.software_engineering.meetu.model.Plan;

import java.util.List;

public class CreatePlanPOJO {

    private String title;
    private String description;
    private List<Plan> plans;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }
}
