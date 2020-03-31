package com.jp.oracle.controllers;

import com.jp.oracle.models.Contact;
import com.jp.oracle.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/api"})
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> findAll(@RequestParam(required = false) String name) {
        List<Contact> users;

        if (name == null)
            users = contactService.findAll();
        else
            users = contactService.findByName(name);

        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(users);
    }

    @GetMapping("contacts/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        Optional<Contact> contact = contactService.findById(id);
        if (!contact.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact.get());
    }

    @PostMapping("/contacts")
    public ResponseEntity create(@Valid @RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.save(contact));
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @Valid @RequestBody Contact contact) {
        if (!contactService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contact.setId(id);
        return ResponseEntity.ok(contactService.save(contact));
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!contactService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contactService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}