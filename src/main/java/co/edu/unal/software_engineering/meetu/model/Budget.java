package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the role database table.
 */
@Entity
@Table( name = "budget", schema = "public" )
public class Budget implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */
    @Id
    @SequenceGenerator( name = "BUDGET_BUDGETID_GENERATOR", sequenceName = "public.budget_budget_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "BUDGET_BUDGETID_GENERATOR", strategy = GenerationType.SEQUENCE )

    @Column( name = "idBudget" )
    private Integer idBudget;

    @Column( name = "money" )
    private Integer money;




    //bi-directional many-to-many association to Plan
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planId")
    private Plan plan;

    /**
     * Constructors
     */

    public Budget( ){ }

    /**
     * Getters and Setters
     */

    public Integer getIdBudget( ){
        return this.idBudget;
    }

    public void setIdBudget( Integer id ){
        this.idBudget = id;
    }

    public Plan getPlan(){
        return plan;
    }

    public void setPlan(Plan plan){
        this.plan = plan;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof Budget) ) return false;
        return idBudget.equals( ((Budget) object).getIdBudget( ) );
    }

    @Override
    public int hashCode( ){
        return idBudget;
    }



}