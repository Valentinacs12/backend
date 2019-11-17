package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


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

    @Column(name = "plan_id")
    private Integer plan_id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // bi-directional one-to-many association to Comment
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Budget> budgets;

    // bi-directional one-to-many association to Location
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Comment> comments;

    // bi-directional one-to-many association to Location
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "plan")
    private List<Location> locations;

    /**
     * Constructors
     */
    public Plan() {
    }


    /**
     * Getters and Setters
     */

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
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

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Methods
     */
    public void addBudget( Budget budget ){
        budgets.add( budget );
    }

    public void addComment( Comment comment ){
        comments.add( comment );
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Plan))
            return false;
        return plan_id.equals(((Plan) object).getPlan_id());
    }

    @Override
    public int hashCode() {
        return plan_id;
    }
}
