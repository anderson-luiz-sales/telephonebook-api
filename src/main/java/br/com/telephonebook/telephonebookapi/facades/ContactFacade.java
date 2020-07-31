package br.com.telephonebook.telephonebookapi.facades;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactResponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.resquests.ContactResquestDTO;

import java.util.List;

public interface ContactFacade {

    ContactResponseDTO save(ContactResquestDTO contactResquestDTO);
    List<ContactResponseDTO> getContact();
    ContactResponseDTO findById(String id);
    ContactResponseDTO update(ContactResquestDTO contactResquestDTO);
    void deleteById(String id);
}
