package com.edithtech.jobportal.contact.service.Impl;

import com.edithtech.jobportal.dto.ContactDto;
import com.edithtech.jobportal.entity.Contact;
import com.edithtech.jobportal.repository.ContactRepository;
import com.edithtech.jobportal.contact.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveCotact(ContactDto contactDto) {
        Contact contactEntity = contactRepository.save(transformToEntity(contactDto));
        boolean result = false;

        if(contactEntity != null){
            result = true;
        }

        return result;
    }

    private Contact transformToEntity(ContactDto contactDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
//        contact.setCreatedAt(Instant.now());
//        contact.setCreatedBy("System");
        contact.setStatus("'NEW'");
        return contact;
    }
}
