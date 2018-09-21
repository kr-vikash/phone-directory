package com.directory.main.repo;

import com.directory.main.modal.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface PhoneRepository  extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
}
