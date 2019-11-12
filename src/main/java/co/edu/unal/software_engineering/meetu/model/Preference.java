
package co.edu.unal.software_engineering.meetu.model;

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
 
public class Preference{

    /**
     * Attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPreference;
    private String event_type_name;

    //bi-directional many-to-one association to Association
    @OneToOne
    @JoinColumn( name = "idUser" )
    private User user;
    
    public Preference(){}

    /**
     * Getters and Setters
     */

    public Integer getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(Integer idPreference) {
        this.idPreference = idPreference;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof Preference) ) return false;
        return idPreference.equals( ((Preference) object).getIdPreference( ) );
    }

    @Override
    public int hashCode( ){
        return idPreference;
    }

    
}

