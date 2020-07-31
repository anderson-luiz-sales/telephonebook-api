package br.com.telephonebook.telephonebookapi.services.Impl;

import br.com.telephonebook.telephonebookapi.clients.HgClientBrasil;
import br.com.telephonebook.telephonebookapi.dtos.responses.hg.HgBrasilTempResponseDTO;
import br.com.telephonebook.telephonebookapi.services.HgBrasilService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class HgBrasilServiceImpl implements HgBrasilService {

    private final HgClientBrasil hgClientBrasil;

    @Override
    public HgBrasilTempResponseDTO getTemp(String city, String uf) {
        return hgClientBrasil.getTemp(city, uf);
    }
}
