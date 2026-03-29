package l7_hibernate_hierarchy.table_per_concrete_class_mapping;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "HomeTask2")
@PrimaryKeyJoinColumn(name = "task_id")
public class HomeTask2 extends Task2 implements Serializable {

    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    })
    private Address homeAddress;

    @Embedded
    private Address address;
}