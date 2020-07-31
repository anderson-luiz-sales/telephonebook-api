package br.com.telephonebook.telephonebookapi.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Contact implements Serializable {

    private String id;
    private String name;
    private String address;
    private String email;
    private List<TelephoneNumber> telephoneNumber;
}
