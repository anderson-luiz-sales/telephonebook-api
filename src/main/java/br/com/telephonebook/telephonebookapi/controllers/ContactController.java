package br.com.telephonebook.telephonebookapi.controllers;

import br.com.telephonebook.telephonebookapi.dtos.responses.ContactResponseDTO;
import br.com.telephonebook.telephonebookapi.dtos.resquests.ContactResquestDTO;
import br.com.telephonebook.telephonebookapi.facades.ContactFacade;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class ContactController {

    private final ContactFacade contactFacade;

    @ApiOperation(value = "Post Contacts v1")
    @PostMapping
    public ResponseEntity<ContactResponseDTO> create(@RequestBody ContactResquestDTO contactResquestDTO) {
        return new ResponseEntity<>(contactFacade.save(contactResquestDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Contacts v1")
    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> list() {
        return new ResponseEntity<>(contactFacade.getContact(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get By Id Contacts v1")
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(contactFacade.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Put Contacts v1")
    @PutMapping
    public ResponseEntity<ContactResponseDTO> update(@RequestBody ContactResquestDTO contactResquestDTO) {
        return new ResponseEntity<>(contactFacade.update(contactResquestDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Contact v1")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        contactFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
