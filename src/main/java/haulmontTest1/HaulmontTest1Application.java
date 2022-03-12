package haulmontTest1;


import haulmontTest1.repository.ApartmentsRepository;
import haulmontTest1.repository.ClientRepository;
import haulmontTest1.repository.RegistrationCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//
import haulmontTest1.entity.Apartments;
import haulmontTest1.entity.Client;
import haulmontTest1.entity.RegistrationCard;
import java.time.LocalDate;
import java.time.LocalDateTime;
//

@SpringBootApplication
public class HaulmontTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(HaulmontTest1Application.class, args);
    }


    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ApartmentsRepository apartmentsRepository;
    @Autowired
    RegistrationCardRepository regRep;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
//        Client.Contacts contacts = new Client.Contacts(
//                null,
//                "211",
//                "sample@gmail.com");
//        Client client = new Client(
//                null,
//                "Владислав",
//                "Игорь",
//                "Валерьевич",
//                null,
//                contacts
//        );
//
//        Client.Contacts contacts2 = new Client.Contacts(
//                null,
//                "55",
//                "sample@yandex.ru");
//        Client client2 = new Client(
//                null,
//                "Игорь",
//                "Олег",
//                "Владиславовыч",
//                null,
//                contacts2
//        );
//
//        Client.Contacts contacts3 = new Client.Contacts(
//                null,
//                "8800",
//                "sample@yahoo.com");
//        Client client3 = new Client(
//                null,
//                "Олег",
//                "Клиент",
//                "Игоревич",
//                null,
//                contacts3
//        );
//        clientRepository.save(client);
//        clientRepository.save(client2);
//        clientRepository.save(client3);
//
//        Apartments apartments = apartmentsRepository.save(new Apartments(null, 1L, true, false));
//        Apartments apartments2 = apartmentsRepository.save(new Apartments(null, 2L, false, false));
//        Apartments apartments3 = apartmentsRepository.save(new Apartments(null, 3L, true, true));
//
//        RegistrationCard registrationCard = new RegistrationCard(
//                null,
//                client,
//                apartments,
//                LocalDate.now().minusDays(1),
//                LocalDate.now(),
//                false,
//                false,
//                null,
//                null,
//                LocalDateTime.now().minusHours(25),
//                false);
//
//
//        RegistrationCard registrationCard2 = new RegistrationCard(
//                null,
//                client2,
//                apartments2,
//                LocalDate.now().minusDays(2),
//                LocalDate.now().plusDays(3),
//                false,
//                false,
//                null,
//                null,
//                LocalDateTime.now(),
//                false);
//
//        RegistrationCard registrationCard3 = new RegistrationCard(
//                null,
//                client3,
//                apartments3,
//                LocalDate.now(),
//                LocalDate.now().plusDays(3),
//                false,
//                false,
//                null,
//                null,
//                LocalDateTime.now(),
//                false);
//        regRep.save(registrationCard);
//        regRep.save(registrationCard2);
//        regRep.save(registrationCard3);
    }
}
