package haulmontTest1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static haulmontTest1.entity.Client.*;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    public Contacts save(Contacts contacts);
}
