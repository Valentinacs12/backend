package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "location", schema = "public")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator(name = "LOCATION_LOCATIONID_GENERATOR", sequenceName = "public.location_location_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "LOCATION_LOCATIONID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "idLocation")

    private Integer idLocation;

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

    public Location() {
    }

    /**
     * Getters and Setters
     */

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
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
        if (!(object instanceof Location))
            return false;
        return idLocation.equals(((Location) object).getIdLocation());
    }

    @Override
    public int hashCode() {
        return idLocation;
    }

}