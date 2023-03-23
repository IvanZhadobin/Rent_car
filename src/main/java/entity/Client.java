package entity;

import java.time.LocalDate;

public class Client {
    private final Long id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private final LocalDate birthday;
    private String passport;
    private String driverLicense;

    public Client(Long id, String firstname, String lastname, String patronymic, LocalDate birthday, String passport, String driverLicense) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passport = passport;
        this.driverLicense = driverLicense;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", passport='" + passport + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }
}
