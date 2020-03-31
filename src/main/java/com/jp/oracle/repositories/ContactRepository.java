package com.jp.oracle.repositories;

import com.jp.oracle.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    public List<Contact> findByName(String name);
}