package com.jp.oracle.services;

import com.jp.oracle.models.Contact;
import java.util.List;
import java.util.Optional;

public interface ContactService {

    public List<Contact> findAll();
    public Optional<Contact> findById(Long id);
    public Contact save(Contact contact);
    public void deleteById(Long id);
    public List<Contact> findByName(String name);
}