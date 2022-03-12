package haulmontTest1.repository;

import haulmontTest1.entity.Apartments;
import haulmontTest1.entity.Client;
import haulmontTest1.entity.RegistrationCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationCardRepository extends JpaRepository<RegistrationCard, Long> {
    RegistrationCard findAllById(Long id);

    RegistrationCard findByApartment(Apartments apartment);

    List<RegistrationCard> findAllByApartment(Apartments apartment);

    List<RegistrationCard> findAllByClient(Client client);

    List<RegistrationCard> deleteAllByApartment(Apartments apartments);
}
