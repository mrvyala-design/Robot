package l7_hibernate_hierarchy.table_per_class_hierarchy;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Work")
@SuperBuilder
public class WorkTask extends Task implements Serializable {

    @Column
    private  double cost;
}
