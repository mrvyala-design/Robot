package l5_dao.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Person {

    private long id;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private LocalDate dateOfBirthday;
    private LocalDateTime dateTimeCreate;
    private LocalTime timeToLunch;
    private String letter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public LocalDateTime getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(LocalDateTime dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public LocalTime getTimeToLunch() {
        return timeToLunch;
    }

    public void setTimeToLunch(LocalTime timeToLunch) {
        this.timeToLunch = timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", dateTimeCreate=" + dateTimeCreate +
                ", timeToLunch=" + timeToLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}
