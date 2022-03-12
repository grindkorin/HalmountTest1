package haulmontTest1.adapter;

import lombok.Data;


@Data
public class RegistrationCardDto {
    private Long id;
    private Long apartment;
    private Long clientId;
    private String arrival;
    private String leaving;
    private Boolean paid;
    private Boolean prepayment;
    private String paidDate;
    private String prepaymentDate;
    private String bookedDate;
    private Boolean covidTest;
    private String clientPhone;
}
