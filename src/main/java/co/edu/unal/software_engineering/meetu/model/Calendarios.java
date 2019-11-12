
package co.edu.unal.software_engineering.meetu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;




/**
 * The persistent class for the user database table.
 */
@Entity

public class Calendarios {

    /**
     * Attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCalendar")
    private Integer idCalendar;

    // @JsonIgnore
    private Integer day_number;
    private Date day_date;
    private Date time_in_hours;
    private String other_details;

    // bi-directional one-to-one association to User
    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Calendarios() {
    }

    public Integer getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDay_number() {
        return day_number;
    }

    public void setDay_number(Integer day_number) {
        this.day_number = day_number;
    }

    public Date getDay_date() {
        return day_date;
    }

    public void setDay_date(Date day_date) {
        this.day_date = day_date;
    }

    public Date getTime_in_hours() {
        return time_in_hours;
    }

    public void setTime_in_hours(Date time_in_hours) {
        this.time_in_hours = time_in_hours;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Calendarios))
            return false;
        return idCalendar.equals(((Calendarios) object).getIdCalendar());
    }

    @Override
    public int hashCode() {
        return idCalendar;
    }

}
