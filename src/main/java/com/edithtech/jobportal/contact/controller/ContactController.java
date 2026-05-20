package com.edithtech.jobportal.contact.controller;

import com.edithtech.jobportal.dto.ContactDto;
import com.edithtech.jobportal.contact.service.IContactService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;


    @GetMapping(version = "1.0")
    public ResponseEntity<String> fetchOpenContacts(@RequestParam
                                                        @Validated @NotBlank(message = "Status can not be blank/empty")
                                                        @Size(min = 4, message = "Min 4 characters are required") String status){
        return ResponseEntity.ok("Contacts: "+status);
    }

    @PostMapping(version = "1.0")
    private ResponseEntity<String> contactUs(@RequestBody @Valid ContactDto contactDtoRequestBody){

        boolean isSaved = contactService.saveCotact(contactDtoRequestBody);
        if(isSaved){
            return ResponseEntity.status(HttpStatus.CREATED).body("Request Processed Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request failed");
        }
    }


}
