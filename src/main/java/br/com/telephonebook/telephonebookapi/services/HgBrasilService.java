package br.com.telephonebook.telephonebookapi.services;

import br.com.telephonebook.telephonebookapi.dtos.responses.hg.HgBrasilTempResponseDTO;

public interface HgBrasilService {

    HgBrasilTempResponseDTO getTemp(String city, String uf);
}
