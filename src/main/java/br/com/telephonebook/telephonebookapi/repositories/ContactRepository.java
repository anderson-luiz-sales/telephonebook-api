package br.com.telephonebook.telephonebookapi.repositories;

import br.com.telephonebook.telephonebookapi.entities.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {

    Contact findByid(String id);
}
