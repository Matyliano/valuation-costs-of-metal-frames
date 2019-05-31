package matyliano.valuation.data.hourlyWage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "work_wage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//public class HourlyWage {
public class HourlyWage implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "work_name")
    private String workName;

    @Column(name = "price")
    private Double price;

    @Column(name = "start_date_work")
    private LocalDateTime workStartDate;

    @Column(name = "end_date_work")
    private LocalDateTime workEndDate;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName( String workName ) {
        this.workName = workName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public LocalDateTime getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate( LocalDateTime workStartDate ) {
        this.workStartDate = workStartDate;
    }

    public LocalDateTime getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate( LocalDateTime workEndDate ) {
        this.workEndDate = workEndDate;
    }
}

