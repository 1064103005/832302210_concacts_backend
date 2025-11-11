package com.example.contacts.service;

import com.example.contacts.entity.Contact;
import com.example.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }

    public Contact addContact(Contact contact) {
        if (contactRepository.existsByPhone(contact.getPhone())) {
            throw new RuntimeException("电话号码已存在: " + contact.getPhone());
        }
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact contactDetails) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();

            if (!contact.getPhone().equals(contactDetails.getPhone()) &&
                    contactRepository.existsByPhone(contactDetails.getPhone())) {
                throw new RuntimeException("电话号码已存在: " + contactDetails.getPhone());
            }

            contact.setName(contactDetails.getName());
            contact.setPhone(contactDetails.getPhone());
            contact.setEmail(contactDetails.getEmail());
            contact.setAddress(contactDetails.getAddress());
            return contactRepository.save(contact);
        }
        return null;
    }

    public boolean deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Contact> searchContacts(String keyword) {
        return contactRepository.searchContacts(keyword);
    }

    public boolean phoneExists(String phone) {
        return contactRepository.existsByPhone(phone);
    }
}