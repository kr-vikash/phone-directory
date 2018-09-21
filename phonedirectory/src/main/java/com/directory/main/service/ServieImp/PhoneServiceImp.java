package com.directory.main.service.ServieImp;

import com.directory.main.modal.Contact;
import com.directory.main.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImp implements PhoneService {



    @Override
    public long checkDublicates(List<Contact> contacts, Contact contact) {
        for (Contact c:contacts){
           if(c.getPhoneNumber().equals(contact.getPhoneNumber())){
               return c.getId();
           }
        }
        return -1;
    }
}
