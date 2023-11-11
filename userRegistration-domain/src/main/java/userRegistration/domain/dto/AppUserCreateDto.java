package userRegistration.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class AppUserCreateDto implements Serializable {
    private static final long serialVersionUID = 4931695275985181971L;
    private  String name;
    private  String surname;
    private String gender;
    private String email;
    private String password;
    public AppUserCreateDto(String name, String surname, String gender, String email, String password){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUserCreateDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserCreateDto that = (AppUserCreateDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(gender, that.gender) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, email, password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
