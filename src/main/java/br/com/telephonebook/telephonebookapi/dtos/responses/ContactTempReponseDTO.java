package br.com.telephonebook.telephonebookapi.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactTempReponseDTO implements Serializable {

    private String id;
    private String name;
    private String address;
    private String email;
    private String city;
    private String uf;
    private Integer temp;
    private String description;
    private String message;
}
