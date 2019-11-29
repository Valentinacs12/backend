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
@Table( name = "user", schema = "public" )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "USER_USERID_GENERATOR", sequenceName = "public.user_user_id_seq", allocationSize = 1 )
    @GeneratedValue( generator = "USER_USERID_GENERATOR", strategy = GenerationType.SEQUENCE )


    @Column( name = "user_id" )
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "last_name")
    private String last_name;

    @JsonIgnore
    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Lob
    @Column(name = "image")
    private Blob image;

    @Column(name = "password")
    private String password;

    //bi-directional many-to-many association to Role
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)    // TODO verificar (fetch = FetchType.EAGER)
    @JoinTable( name = "user_role", joinColumns = { @JoinColumn( name = "user_id" ) },
            inverseJoinColumns = { @JoinColumn( name = "role_id" ) } )
    private List<Role> roles;

    /**
     * Constructors
     */

    public User( ){ }

    /**
     * Getters and Setters
     */

    public Integer getId( ){
        return this.id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getUsername( ){
        return this.username;
    }

    public void setUsername( String username ){
        this.username = username;
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

    public String getPassword( ){
        return this.password;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public List<Role> getRoles( ){
        return this.roles;
    }

    public void setRoles( List<Role> roles ){
        this.roles = roles;
    }

    /**
     * Methods
     */

    public void addRole( Role role ){
        roles.add( role );
    }

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof User) ) return false;
        return id.equals( ((User) object).getId( ) );
    }

    @Override
    public int hashCode( ){
        return id;
    }
}