package haulmontTest1.service;

import haulmontTest1.adapter.RegistrationCardDto;
import haulmontTest1.entity.Apartments;
import haulmontTest1.entity.RegistrationCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class BookingService {
    //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    RegistrationCardService cardService;
    @Autowired
    ClientService clientService;
    @Autowired
    ApartmentService apartmentService;


    private boolean checkClient(RegistrationCardDto dto) throws Exception {
        if (clientService.findByPhone(dto.getClientPhone()) != null) {
            return true;
        } else {
            throw new Exception("Пользователя с таким номером не существует!");
        }
    }

    private boolean checkApartmentExisting(Long number) throws Exception {
        if (apartmentService.findByNumber(number) != null) {
            return true;
        } else {
            throw new Exception("Такой комнаты не существует");
        }
    }


    private boolean checkRoom(RegistrationCardDto dto, RegistrationCard registrationCard) throws Exception {
        if (dto.getApartment().equals(registrationCard.getApartment().getNumber()))
            if (ChronoUnit.DAYS.between(LocalDate.parse(dto.getArrival()), LocalDate.now()) <= 0) {
                throw new Exception("В этот день комната занята");
            } else {
                return true;
            }
        return true;
    }

    public boolean brandNewCard(RegistrationCardDto dto, RegistrationCard card) throws Exception {
        if (checkRoom(dto, card) & checkClient(dto))
            return true;
        throw new Exception("С созданием брони произошёл казус");
    }

    public RegistrationCard bookedCard(RegistrationCardDto dto) throws Exception {
        LocalDateTime paidDate = null;
        LocalDateTime prepaymentDate = null;
        LocalDateTime bookedDate = null;
        if (dto.getPaid() != null) {
            if (dto.getPaid())
                paidDate = LocalDateTime.now();
            dto.setPrepayment(false);
        } else if (dto.getPrepayment() != null) {
            if (dto.getPrepayment())
                prepaymentDate = LocalDateTime.now();
            dto.setPaid(false);
        } else {
            bookedDate = LocalDateTime.now();
            dto.setPrepayment(false);
            dto.setPaid(false);
        }
        checkApartmentExisting(dto.getApartment());
        Apartments byNumber = apartmentService.findByNumber(dto.getApartment());
        byNumber.setBooked(true);
        return new RegistrationCard(
                null,
                clientService.findByPhone(dto.getClientPhone()),
                byNumber,
                LocalDate.parse(dto.getArrival()),
                LocalDate.parse(dto.getLeaving()),
                dto.getPaid(),
                dto.getPrepayment(),
                paidDate,
                prepaymentDate,
                bookedDate,
                false
        );
    }


}
