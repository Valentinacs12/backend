package co.edu.unal.software_engineering.meetu.pojo;

import co.edu.unal.software_engineering.meetu.model.Budget;

import java.util.List;

public class CreatePlanPOJO {

    private String title;
    private String description;
    private List<Budget> budgets;


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

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }
}
