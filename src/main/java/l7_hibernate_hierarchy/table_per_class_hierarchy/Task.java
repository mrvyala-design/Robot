package l7_hibernate_hierarchy.table_per_class_hierarchy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TASK_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Base")
@Entity
@Table(name = "Task")
@SuperBuilder
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
}
