package br.com.telephonebook.telephonebookapi.dtos.responses.hg;

import lombok.Data;

import java.io.Serializable;

@Data
public class HgBrasilTempResponseDTO implements Serializable {

    private HgResultsResponseDTO results;
}
