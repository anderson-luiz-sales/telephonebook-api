package br.com.telephonebook.telephonebookapi.dtos.resquests;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelephoneNumberRequestDTO implements Serializable {

    private String phone;
}
