package l7_hibernate_hierarchy.table_per_concrete_class_mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "WorkTask2")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask2 extends Task2 implements Serializable {

    @Column
    private  double cost;
}