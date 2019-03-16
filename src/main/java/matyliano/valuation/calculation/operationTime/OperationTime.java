package matyliano.valuation.calculation.operationTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation_time")
public class OperationTime {


    @Id
    public Long id;

    @NotBlank
    public double operationTime;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public double getOperationTime() {
        return operationTime;
    }

    public void setOperationTime( double operationTime ) {
        this.operationTime = operationTime;
    }
}
