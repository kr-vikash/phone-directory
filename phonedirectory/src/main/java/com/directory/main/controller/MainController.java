package com.directory.main.controller;


import com.directory.main.modal.Contact;
import com.directory.main.repo.PhoneRepository;
import com.directory.main.service.PhoneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/detail")
public class MainController {
    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

        @Autowired
        private PhoneRepository phoneRepository;

        @Autowired
        private PhoneService phoneService;

    /**
     *
     * @param contact
     * @return
     */
    @PostMapping(value = "/create")
        public ResponseEntity<?> create(@RequestBody Contact contact) {
        List<Contact> contacts= (List<Contact>) phoneRepository.findAll();
        Contact contact1 = null;
        long id=phoneService.checkDublicates(contacts,contact);
          if (id!=-1){
              contact1=phoneRepository.findOne(id);
              LOGGER.info("Dublicate Phone number found belongs to " +contact.getPhoneNumber());
          }else {
              phoneRepository.save(contact);
          }
            return ResponseEntity.ok().body(contact1);
        }

    /**
     *
     * @return
     */
    @GetMapping(value = "/all")
        public List<Contact> read() {
        List<Contact> contacts= (List<Contact>) phoneRepository.findAll();
        return  contacts;
        }

    /**
     *
     * @param contact
     */
        @PutMapping(value = "/update")
        public ResponseEntity<?> update(@RequestBody Contact contact) {
            phoneRepository.save(contact);
            return ResponseEntity.ok().body("updated successfully");
        }

    /**
     *
     * @param id
     * @return
     */
        @DeleteMapping(value = "/{id}")
        public List<Contact> delete(@PathVariable long id) {
            LOGGER.info("Contact deleted!!! ");
            phoneRepository.delete(id);
            return (List<Contact>) phoneRepository.findAll();
        }
    }
