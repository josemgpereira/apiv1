package com.jp.oracle.bootstrap;

import com.jp.oracle.models.Contact;
import com.jp.oracle.repositories.ContactRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContactLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ContactRepository contactRepository;

    private Logger log = LogManager.getLogger(ContactLoader.class);

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Contact contact = new Contact();
        contact.setName("jose");
        contact.setEmail("jose@gmail.com");
        contact.setPhone("912222222");
        contactRepository.save(contact);

        log.info("Saved Contact - id: " + contact.getId());
    }
}