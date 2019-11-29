
package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/*

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/

/**
 * The persistent class for the plan database table.
 */
@Entity
@Table(name = "plan", schema = "public")
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator(name = "PLAN_PLANID_GENERATOR", sequenceName = "public.plan_plan_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "PLAN_PLANID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "idPlan")

    private Integer idPlan;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    // bi-directional one-to-many association to Comment

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Comment> comments;

    /*
     * // bi-directional many-to-many association to User ??????
     * 
     * @JsonIgnore
     * 
     * @ManyToMany(mappedBy = "plans") private List<User> users;
     */

    // bi-directional One-to-many association to Role
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Budget> budgets;

    // bi-directional one-to-many association to Location

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Location> locations;

    // bi-directional one-to-many association to Date

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "plan")
    private List<PossibleDate> dates;

    // bi-directional many-to-many association to Option

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Option> options;

    /**
     * Constructors
     */

    public Plan() {
    }

    /**
     * Getters and Setters
     */
    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

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

    /*
     * public List<Comment> getComments() { return comments; }
     * 
     * public void setComments(List<Comment> comments) { this.comments = comments; }
     * 
     * public List<User> getUsers() { return users; }
     * 
     * public void setUsers(List<User> users) { this.users = users; }
     */
    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }
    /*
     * public List<Location> getLocations() { return locations; }
     * 
     * public void setLocations(List<Location> locations) { this.locations =
     * locations; }
     * 
     * public List<Date> getDates() { return dates; }
     * 
     * public void setDates(List<Date> dates) { this.dates = dates; }
     * 
     * public List<Option> getOptions() { return options; }
     * 
     * public void setOptions(List<Option> options) { this.options = options; }
     */

    /**
     * Methods
     */

    public void addBudget( Budget budget ){
        budgets.add( budget );
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Plan))
            return false;
        return idPlan.equals(((Plan) object).getIdPlan());
    }

    @Override
    public int hashCode() {
        return idPlan;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Location> getLocation() {
        return locations;
    }

    public void setLocation(List<Location> location) {
        this.locations = location;
    }

    public List<PossibleDate> getDates() {
        return dates;
    }

    public void setDates(List<PossibleDate> dates) {
        this.dates = dates;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}
