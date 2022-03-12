package haulmontTest1.entity;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String name;
    @Column()
    private String patronymic;

    @OneToMany(mappedBy = "client",
            cascade = CascadeType.ALL)
    private List<RegistrationCard> registrationCards;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contacts_id", referencedColumnName = "id")
    private Contacts contacts;


    @Data
    @Entity
    @Table(name = "contact")
    public static class Contacts {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(nullable = false, unique = true)
        private String phone;
        @Column(nullable = false, unique = true)
        private String email;

        public Contacts() {
        }

        public Contacts(Long id, String phone, String email) {
            this.id = id;
            this.phone = phone;
            this.email = email;
        }


    }

}
