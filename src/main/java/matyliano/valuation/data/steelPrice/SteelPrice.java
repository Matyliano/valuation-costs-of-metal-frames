package matyliano.valuation.data.steelPrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price_of_steel")
public class SteelPrice {

    @Id
    @GeneratedValue
    public Long id;

    @NotNull
    @DecimalMin("0.0")
    public Double steelPrice;

    public LocalDate startDate = LocalDate.now();


//    public LocalDate endDate;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @NotNull
    public Double getSteelPrice() {
        return steelPrice;
    }

    public void setSteelPrice( @NotNull Double steelPrice ) {
        this.steelPrice = steelPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate( LocalDate startDate ) {
        this.startDate = startDate;
    }
}
