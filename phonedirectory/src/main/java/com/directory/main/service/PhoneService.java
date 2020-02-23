package com.directory.main.service;

import com.directory.main.modal.Contact;
import com.directory.main.modal.User;

import java.util.List;

/**
 *
 */
public interface PhoneService {
    long checkDublicates(List<Contact> contacts, Contact contact);

    long saveProfile(User user);

}
