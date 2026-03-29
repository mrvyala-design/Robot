package l7_hibernate_hierarchy.table_per_concrete_class_mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable {

    @Column
    public String street;
    @Column
    public String city;
}