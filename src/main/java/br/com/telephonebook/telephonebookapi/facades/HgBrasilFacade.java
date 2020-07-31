package br.com.telephonebook.telephonebookapi.facades;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactTempReponseDTO;

public interface HgBrasilFacade {

    ContactTempReponseDTO getTemp(String id);
}
