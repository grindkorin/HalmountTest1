package haulmontTest1.service;

import haulmontTest1.entity.Apartments;
import haulmontTest1.repository.ApartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentsRepository apartmentsRepository;
    @Autowired
    private RegistrationCardService cardService;

    public Apartments getById(Long id) {
        return apartmentsRepository.getById(id);
    }

    public List<Apartments> findAll() {
        return apartmentsRepository.findAll();
    }

    public Optional<Apartments> findById(Long id) {
        return apartmentsRepository.findById(id);
    }

    public List<Apartments> findAllByOccupiedFalse() {
        return apartmentsRepository.findAllByOccupiedFalse();
    }

    public List<Apartments> findAllByOccupiedTrue() {
        return apartmentsRepository.findAllByOccupiedTrue();
    }

    public List<Apartments> findAllFree() {
        return apartmentsRepository.findAllByOccupiedFalseAndBookedFalse();
    }

    public List<Apartments> findAllByBookedTrue() {
        return apartmentsRepository.findAllByBookedTrue();
    }

    public Apartments save(Apartments apartments) {
        return apartmentsRepository.save(apartments);
    }

    @Transactional
    public void deleteById(Long id) {
        if (getById(id) != null)
            cardService.deleteAllByApartment(getById(id));
        apartmentsRepository.deleteById(id);
    }

    public Apartments findByNumber(Long number) {
        return apartmentsRepository.findByNumber(number);
    }
}
