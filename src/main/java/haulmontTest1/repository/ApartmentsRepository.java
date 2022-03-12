package haulmontTest1.repository;

import haulmontTest1.entity.Apartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartmentsRepository extends JpaRepository<Apartments, Long> {
    List<Apartments> findAll();

    Optional<Apartments> findById(Long id);

    List<Apartments> findAllByOccupiedFalse();

    List<Apartments> findAllByOccupiedFalseAndBookedFalse();

    List<Apartments> findAllByOccupiedTrue();

    List<Apartments> findAllByBookedTrue();

    Apartments findByNumber(Long number);
}
