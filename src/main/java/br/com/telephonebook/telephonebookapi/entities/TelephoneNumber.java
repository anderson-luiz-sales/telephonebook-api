package br.com.telephonebook.telephonebookapi.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelephoneNumber implements Serializable {

    private String phone;
}
