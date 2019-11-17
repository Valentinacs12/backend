package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table( name = "plan", schema = "public" )
public class Plan implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "PLAN_PLANID_GENERATOR", sequenceName = "public.plan_plan_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "PLAN_PLANID_GENERATOR", strategy = GenerationType.SEQUENCE )


    @Column( name = "idPlan" )
    private Integer idPlan;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    //bi-directional many-to-many association to Role
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "plan")
    private List<Budget> budgets;


    /**
     * Constructors
     */

    public Plan( ){ }

    /**
     * Getters and Setters
     */

    public Integer getIdPlan( ){
        return this.idPlan;
    }

    public void setIdPlan( Integer idPlan ){
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

    public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }


    /**
     * Methods
     */

    public void addBudget( Budget budget ){
        budgets.add( budget );
    }


    @Override
    public boolean equals( Object object ){
        if( !(object instanceof Plan) ) return false;
        return idPlan.equals( ((Plan) object).getIdPlan( ) );
    }

    @Override
    public int hashCode( ){
        return idPlan;
    }
}