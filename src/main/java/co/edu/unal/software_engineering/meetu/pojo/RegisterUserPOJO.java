package co.edu.unal.software_engineering.meetu.pojo;

public class RegisterUserPOJO{

    private String password;
    private String username;
    private String last_name;
    private String phone_number;
    private String email;
    private String city;



    public String getPassword( ){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }

    public String getUsername( ){
        return username;
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

}
