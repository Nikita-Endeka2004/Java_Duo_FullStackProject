package userRegistration.domain;

import java.io.Serializable;
import java.util.Objects;

public class AppUser implements Serializable {

    private static final long seralVersionUID = -8216534840561913340L;
    private Long id;
    private  String name;
    private  String surname;
    private String gender;
    private String email;
    private String password;
    public AppUser() {

    }

    public AppUser(Long id, String name, String surname, String gender, String email, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Override
    public String toString(){
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) &&
                Objects.equals(name, appUser.name) &&
                Objects.equals(surname,appUser.surname) &&
                Objects.equals(gender, appUser.gender) &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(password, appUser.password);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, name, surname, gender, email, password);
    }
}
