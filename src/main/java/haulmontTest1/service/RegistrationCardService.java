package haulmontTest1.service;


import haulmontTest1.adapter.RegistrationCardDto;
import haulmontTest1.entity.Apartments;
import haulmontTest1.entity.Client;
import haulmontTest1.entity.RegistrationCard;
import haulmontTest1.repository.ApartmentsRepository;
import haulmontTest1.repository.ClientRepository;
import haulmontTest1.repository.RegistrationCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RegistrationCardService {
    @Autowired
    RegistrationCardRepository cardRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ApartmentsRepository apartmentsRepository;


    public List<RegistrationCard> findAllByClient(Client client) {
        return cardRepository.findAllByClient(client);
    }

    public List<RegistrationCard> findAllByApartment(Apartments apartment) {
        return cardRepository.findAllByApartment(apartment);
    }

    public List<RegistrationCard> deleteAllByApartment(Apartments apartment) {
        return cardRepository.deleteAllByApartment((apartment));
    }

    public List<RegistrationCard> findAll() {
        return cardRepository.findAll();
    }

    public RegistrationCard getById(Long id) {
        return cardRepository.getById(id);
    }


    public RegistrationCard fromDto(RegistrationCardDto dto) {

        RegistrationCard card = new RegistrationCard(
                dto.getId(),
                clientRepository.getById(dto.getClientId()),
                apartmentsRepository.findByNumber(dto.getApartment()),
                LocalDate.parse(dto.getArrival()),
                LocalDate.parse(dto.getLeaving()),
                dto.getPaid(),
                dto.getPrepayment(),
                checkDateNullable(dto.getPaidDate()),
                checkDateNullable(dto.getPrepaymentDate()),
                checkDateNullable(dto.getBookedDate()),
                dto.getCovidTest()
        );
        if (!card.getPaid()) {
            card.setArrival(getById(dto.getId()).getArrival());
            card.setLeaving(getById(dto.getId()).getLeaving());
        }
        return card;
    }

    private LocalDateTime checkDateNullable(String date) {
        return date.equals("") ? null : LocalDateTime.parse(date);
    }

    public void save(RegistrationCard registrationCard) {
        cardRepository.save(registrationCard);
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    public void covidTest(List<RegistrationCard> cards) {
        cards.stream()
                .filter(RegistrationCard::getCovidTest)
                .forEach(card -> {
                    card.setPaid(false);
                    card.getApartment().setBooked(false);
                    card.getApartment().setOccupied(false);
                    card.setPrepayment(false);
                });
    }


    public void bookedStatus(List<RegistrationCard> cards) {
        cards.stream()
                .filter(card -> !card.getPaid()
                        & !card.getPrepayment()
                        & hoursDifference(card) > 24)
                .forEach(card -> {
                    card.getApartment().setBooked(false);
                });
    }

    private long hoursDifference(RegistrationCard card) {
        if (card.getBookedDate() != null) {
            return ChronoUnit.HOURS.between(card.getBookedDate(), LocalDateTime.now());
        }
        return 0L;
    }

    public void setOccupied(List<RegistrationCard> cards) {
        cards.stream()
                .filter(card -> (card.getPaid()
                        || card.getPrepayment())
                        & (ChronoUnit.DAYS.between(card.getArrival(), LocalDate.now())) == 0)
                .forEach(card -> card.getApartment().setOccupied(true));
    }

    public void allCardsCheck(List<RegistrationCard> cards) {
        bookedStatus(cards);
        covidTest(cards);
        setOccupied(cards);
        setDates(cards);
        cardRepository.saveAll(cards);
    }


    public void setDates(List<RegistrationCard> cards) {
        cards.stream()
                .filter(RegistrationCard::getPrepayment)
                .forEach(card -> {
                    card.setPrepaymentDate(LocalDateTime.now());
                    card.setPaidDate(null);
                });

        cards.stream()
                .filter(card -> !card.getPrepayment())
                .forEach(card -> card.setPrepaymentDate((null)));

        cards.stream()
                .filter(RegistrationCard::getPaid)
                .forEach(card -> card.setPaidDate(LocalDateTime.now()));

        cards.stream()
                .filter(card -> !card.getPaid())
                .forEach(card -> card.setPaidDate(null));
    }

    public RegistrationCard getByApartment(Apartments apartment) {
        return cardRepository.findByApartment(apartment);
    }
}
