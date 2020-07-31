package br.com.telephonebook.telephonebookapi.facades.Impl;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactResponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.responses.TelephoneNumberResponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.resquests.ContactResquestDTO;
import br.com.telephonebook.telephonebookapi.entities.Contact;
import br.com.telephonebook.telephonebookapi.entities.TelephoneNumber;
import br.com.telephonebook.telephonebookapi.facades.ContactFacade;
import br.com.telephonebook.telephonebookapi.services.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ContactFacadeImpl implements ContactFacade {

    private ContactService contactService;

    private final ModelMapper modelMapper;

    @Override
    public ContactResponseDTO save(ContactResquestDTO contactResquestDTO) {
        return convertToDTO(contactService.save(convertToEntity(contactResquestDTO)));
    }

    @Override
    public List<ContactResponseDTO> getContact() {
        List<ContactResponseDTO> contactList = new ArrayList<>();

        for (Contact contact : contactService.getContact()) {
            ContactResponseDTO contactResponseDTO = convertToDTO(contact);
            contactResponseDTO.setTelephoneNumber(new ArrayList<>());

            contactList.add(contactResponseDTO);

            for (TelephoneNumber telephoneNumber : contact.getTelephoneNumber()) {
                TelephoneNumberResponseDTO telephoneNumberResponseDTO = convertToDTO(telephoneNumber);

                contactResponseDTO.getTelephoneNumber().add(telephoneNumberResponseDTO);

            }
        }
        return contactList;
    }

    @Override
    public ContactResponseDTO findById(String id) {
        return convertToDTO(contactService.findById(id));
    }

    @Override
    public ContactResponseDTO update(ContactResquestDTO contactResquestDTO) {
        return convertToDTO(contactService.save(convertToEntity(contactResquestDTO)));
    }

    @Override
    public void deleteById(String id) {
        contactService.deleteById(id);
    }

    private Contact convertToEntity(ContactResquestDTO contactResquestDTO) {
        return modelMapper.map(contactResquestDTO, Contact.class);
    }

    private ContactResponseDTO convertToDTO(Contact contact) {
        return modelMapper.map(contact, ContactResponseDTO.class);
    }

    private TelephoneNumberResponseDTO convertToDTO(TelephoneNumber telephoneNumber) {
        return modelMapper.map(telephoneNumber, TelephoneNumberResponseDTO.class);
    }
}

