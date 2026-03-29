package l5_dao.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int age;

    @Column
    private double salary;

    @Column
    private String passport;

    @Column
    private String address;

    @Column
    private LocalDate dateOfBirthday;

    @Column
    private LocalDateTime dateTimeCreate;

    @Column
    private LocalTime timeToLunch;

    @Column
    private String letter;
}
