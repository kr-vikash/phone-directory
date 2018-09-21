package com.directory.main.service;

import com.directory.main.modal.Contact;

import java.util.List;

/**
 *
 */
public interface PhoneService {
    public long checkDublicates(List<Contact> contacts, Contact contact);
}
