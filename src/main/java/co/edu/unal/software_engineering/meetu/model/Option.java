package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "option", schema = "public")
public class Option implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator(name = "OPTION_OPTIONID_GENERATOR", sequenceName = "public.option_option_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "OPTION_OPTIONID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "idOption")

    private Integer idOption;

    @Column(name = "name")
    private String name;

    // bi-directional many-to-one association to Plan
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlan")
    private Plan plan;

    /**
     * Constructors
     */

    public Option() {
    }

    /**
     * Getters and Setters
     */

    public Integer getIdOption() {
        return idOption;
    }

    public void setIdOption(Integer idOption) {
        this.idOption = idOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Option))
            return false;
        return idOption.equals(((Option) object).getIdOption());
    }

    @Override
    public int hashCode() {
        return idOption;
    }

}