package br.com.telephonebook.telephonebookapi.services.Impl;

import br.com.telephonebook.telephonebookapi.entities.Contact;
import br.com.telephonebook.telephonebookapi.repositories.ContactRepository;
import br.com.telephonebook.telephonebookapi.services.ContactService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        log.info("[ContactServiceImpl.save] - contact {}", contact);
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getContact() {
        log.info("ContactServiceImpl.findAll");
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(String id) {
        log.info("[ContactServiceImpl.findById] - id: {}");
        return contactRepository.findByid(id);
    }

    @Override
    public void deleteById(String id) {
        log.info("[ContactServiceImpl.deleteById] - id: {}");
        contactRepository.deleteById(id);
    }
}
