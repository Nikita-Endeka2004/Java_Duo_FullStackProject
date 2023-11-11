package userRegistration.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class AppUserViewDto implements Serializable {

    private static final long serialVersionUID = -2656752496981215386L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private  String name;
    private  String surname;
    private String gender;
    private String email;
    public AppUserViewDto(){
        
    }

    public AppUserViewDto(String name, String surname, String gender, String email) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserViewDto that = (AppUserViewDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, email);
    }

    @Override
    public String toString() {
        return "AppUserViewDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
