package br.com.telephonebook.telephonebookapi.controllers;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactTempReponseDTO;
import br.com.telephonebook.telephonebookapi.facades.HgBrasilFacade;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hg-brasil")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class HgBrasilController {

    private final HgBrasilFacade hgBrasilFacade;

    @ApiOperation(value = "Get Hg Brasil v1")
    @GetMapping("/{id}")
    public ResponseEntity<ContactTempReponseDTO> getTempo(@PathVariable String id) {
        return new ResponseEntity<>(hgBrasilFacade.getTemp(id), HttpStatus.OK);
    }
}
