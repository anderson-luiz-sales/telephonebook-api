package br.com.telephonebook.telephonebookapi.dtos.resquests;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ContactResquestDTO implements Serializable {

    private String id;
    private String name;
    private String address;
    private String email;
    private List<TelephoneNumberRequestDTO> telephoneNumber;
}
