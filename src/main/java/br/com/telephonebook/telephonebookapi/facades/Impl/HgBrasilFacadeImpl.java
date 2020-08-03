package br.com.telephonebook.telephonebookapi.facades.Impl;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactTempReponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.responses.hg.HgBrasilTempResponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.responses.hg.HgResultsResponseDTO;
import br.com.telephonebook.telephonebookapi.entities.Contact;
import br.com.telephonebook.telephonebookapi.facades.HgBrasilFacade;
import br.com.telephonebook.telephonebookapi.services.ContactService;
import br.com.telephonebook.telephonebookapi.services.HgBrasilService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class HgBrasilFacadeImpl implements HgBrasilFacade {

    private final HgBrasilService hgBrasilService;

    private ContactService contactService;

    @Override
    public ContactTempReponseDTO getTemp(String id) {
        ContactTempReponseDTO contactTemp = new ContactTempReponseDTO();

        Contact contact = contactService.findById(id);
        
        contactTemp.setId(contact.getId());
        contactTemp.setName(contact.getName());
        contactTemp.setAddress(contact.getAddress());
        contactTemp.setEmail(contact.getEmail());
        contactTemp.setCity(contact.getCity());
        contactTemp.setUf(contact.getUf());
        
        String city = contact.getCity();
        String uf = contact.getUf();

        HgBrasilTempResponseDTO hgBrasilTempResponseDTO = hgBrasilService.getTemp(city, uf);
        HgResultsResponseDTO hgResultsResponseDTO = new HgResultsResponseDTO();

        contactTemp.setTemp(hgBrasilTempResponseDTO.getResults().getTemp());
        contactTemp.setDescription(hgBrasilTempResponseDTO.getResults().getDescription());

        Integer temp = hgBrasilTempResponseDTO.getResults().getTemp();
        String description = hgBrasilTempResponseDTO.getResults().getDescription();

        if(temp <= 18){
            contactTemp.setMessage("Ofereça um chocolate quente ao seu contato...");

        } else if (temp >= 30 && description.equals("ensolarado")) {
            contactTemp.setMessage("Convide seu contato para ir à praia com esse calor!");

        } else if (temp >= 30 && description.equals("chuva") || description.equals("chuviscos")) {
            contactTemp.setMessage("Convide seu contato para tomar um sorvete");

        } else if (temp < 30 && temp > 18 && description.equals("tempo ensolarado")){
            contactTemp.setMessage("Convide seu contato para fazer alguma atividade ao livre");

        } else if (temp < 30 && temp > 18 && description.equals("tempo com chuva") || description.equals("chuviscos")) {
            contactTemp.setMessage("Convide seu contato para ver um filme");
        }

        return contactTemp;
    }
}
