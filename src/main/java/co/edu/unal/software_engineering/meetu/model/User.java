
package co.edu.unal.software_engineering.meetu.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the user database table.
 */
@Entity

public class User {

    /**
     * Attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")

    private Integer idUser;
    private String name;
    private String last_name;

    @JsonIgnore
    private String phone_number;
    private String email;
    private String city;
    @Lob
    private Blob image;
    private String password;

    // bi-directional one-to-one User to Calendar
    @OneToOne
    @JoinColumn(name = "idCalendar")
    private Calendarios calendarios;

    public User() {

    }

    /**
     * Getters and Setters
     */

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendarios getCalendarios() {
        return calendarios;
    }

    public void setCalendarios(Calendarios calendarios) {
        this.calendarios = calendarios;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User))
            return false;
        return idUser.equals(((User) object).getIdUser());
    }

    @Override
    public int hashCode() {
        return idUser;
    }

}
