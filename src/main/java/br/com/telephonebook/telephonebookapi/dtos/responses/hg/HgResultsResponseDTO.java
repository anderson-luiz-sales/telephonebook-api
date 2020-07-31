package br.com.telephonebook.telephonebookapi.dtos.responses.hg;

import lombok.Data;

import java.io.Serializable;

@Data
public class HgResultsResponseDTO implements Serializable {

    private Integer temp;
    private String description;
}
