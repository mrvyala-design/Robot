package l7_hibernate_hierarchy.table_per_subclass;

import jakarta.persistence.*;
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
@Table(name = "WorkTask1")
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask1 extends Task1 implements Serializable {

    @Column
    private  double cost;
}
