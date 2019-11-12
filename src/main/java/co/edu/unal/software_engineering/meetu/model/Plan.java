
package co.edu.unal.software_engineering.meetu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The persistent class for the user database table.
 */
@Entity

public class Plan {

    /**
     * Attributes
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPlan;
    private String title;
    private String description;
    // FK User_idUser
}
