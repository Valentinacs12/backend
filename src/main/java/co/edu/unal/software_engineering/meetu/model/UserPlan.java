
package co.edu.unal.software_engineering.meetu.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Private package class for the relation with M...M table
 */

@Entity
@Table (name = "user_has_plan", schema = "public")

class UserPlan implements Serializable{

    /**
     * Attributes
     */

    @EmbeddedId
    private UserPlanPK userPlanPK;

    /**
     * Constructors
     */

    UserPlan (){
        userRolePK = new UserRolePK()
    }

    /**
     * Getters and Setters
     */

    User getUser(){
        return userPlanPK.getUser();
    }

    void setUser(User user){
        userRolePK.setUser(user);
    }

    Plan getPlan(){
        return userPlanPK.getPlan();
    }

    void setPlan(Plan plan){
        userPlanOK.setPlan();
    }

    /**
     * Methods
     */

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof UserPlan) ) return false;
        UserPlan userRole = (UserPlan) object;
        return getUser( ).getIdUser( ).equals( userRole.getUser( ).getIdUser( ) ) &&
                getPlan( ).getIdPlan( ).equals( userPlan.getPlan( ).getIdPlan( ) );
    }

    @Override
    public int hashCode( ){
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + getUser( ).hashCode( );
        hash = hash * prime + getPlan( ).hashCode( );
        return hash;
    }



}



