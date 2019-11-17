package co.edu.unal.software_engineering.meetu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "date", schema = "public")
public class PossibleDate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator(name = "DATE_DATEID_GENERATOR", sequenceName = "public.date_date_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "DATE_DATEID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "idDate")

    private Integer idDate;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    // bi-directional many-to-one association to Plan
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlan")
    private Plan plan;

    /**
     * Constructors
     */

    public PossibleDate() {
    }

    /**
     * Getters and Setters
     */

    public Integer getIdDate() {
        return idDate;
    }

    public void setIdDate(Integer idDate) {
        this.idDate = idDate;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
        if (!(object instanceof PossibleDate))
            return false;
        return idDate.equals(((PossibleDate) object).getIdDate());
    }

    @Override
    public int hashCode() {
        return idDate;
    }

}