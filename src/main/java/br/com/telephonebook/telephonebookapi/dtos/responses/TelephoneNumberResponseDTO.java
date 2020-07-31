package br.com.telephonebook.telephonebookapi.dtos.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelephoneNumberResponseDTO implements Serializable {

    private String phone;
}
