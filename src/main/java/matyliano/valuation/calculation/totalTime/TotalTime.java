package matyliano.valuation.calculation.totalTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "total_operation_time")
public class TotalTime {

    @Id
    @GeneratedValue
    public Long id;

    @NotBlank
    public double totalTime;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime( double totalTime ) {
        this.totalTime = totalTime;
    }
}
