package haulmontTest1.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration_cards")
public class RegistrationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartments_id", referencedColumnName = "id")
    private Apartments apartment;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrival;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate leaving;
    @Column
    private Boolean paid;
    @Column
    private Boolean prepayment;
    @Column(name = "paid_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime paidDate;
    @Column(name = "prepayment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime prepaymentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime bookedDate;
    @Column(name = "covid_test")
    private Boolean covidTest;


    public Long getClient() {
        return client.getId();
    }

    @Override
    public String toString() {
        return "RegistrationCard{" +
                "id=" + id +
                ", client=" + client.getId() +
                ", apartment=" + apartment +
                ", arrival='" + arrival + '\'' +
                ", leaving='" + leaving + '\'' +
                ", paid=" + paid +
                ", prepayment=" + prepayment +
                ", paidDate='" + paidDate + '\'' +
                ", prepaymentDate='" + prepaymentDate + '\'' +
                ", covidTest=" + covidTest +
                '}';
    }
}

