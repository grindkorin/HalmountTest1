package haulmontTest1.service;

import haulmontTest1.adapter.ClientDto;
import haulmontTest1.entity.Client;
import haulmontTest1.repository.ClientRepository;
import haulmontTest1.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static haulmontTest1.entity.Client.*;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ContactsRepository contactsRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.getById(id);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client fromDto(ClientDto dto) {
        return new Client(
                dto.getId(),
                dto.getLastName(),
                dto.getName(),
                dto.getPatronymic(),
                null,
                new Contacts(
                        null,
                        dto.getPhone(),
                        dto.getEmail()
                )
        );
    }

    public void deleteClientById(Long id) {
        if (getClientById(id) != null)
            clientRepository.deleteById(id);
    }

    public Contacts saveContacts(Contacts contacts) {
        return contactsRepository.save(contacts);
    }

    public List<Contacts> finAllContacts() {
        return contactsRepository.findAll();
    }

    public Client findByPhone(String clientPhone) {
        return clientRepository.findByContacts_Phone(clientPhone);
    }
}
