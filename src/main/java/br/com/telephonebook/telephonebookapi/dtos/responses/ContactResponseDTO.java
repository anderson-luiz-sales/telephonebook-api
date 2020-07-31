package br.com.telephonebook.telephonebookapi.dtos.responses;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContactResponseDTO implements Serializable {

    private String id;
    private String name;
    private String address;
    private String email;
    private List<TelephoneNumberResponseDTO> telephoneNumber;
}
