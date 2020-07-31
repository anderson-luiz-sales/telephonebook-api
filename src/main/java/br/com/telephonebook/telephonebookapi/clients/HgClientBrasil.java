package br.com.telephonebook.telephonebookapi.clients;

import br.com.telephonebook.telephonebookapi.dtos.responses.hg.HgBrasilTempResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="hg-client-api", url="${openfeign.url.hg-brasil-api}")
public interface HgClientBrasil {

    @GetMapping(value = "/weather?key=e95a2058&city_name={city},{uf}")
    HgBrasilTempResponseDTO getTemp(@PathVariable("city") String city,
                                    @PathVariable("uf") String uf);
}
