package br.com.telephonebook.telephonebookapi.services;

import br.com.telephonebook.telephonebookapi.entities.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);
    List<Contact> getContact();
    Contact findById(String id);
    void deleteById(String id);
}
