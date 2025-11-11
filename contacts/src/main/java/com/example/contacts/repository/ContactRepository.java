package com.example.contacts.repository;

import com.example.contacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNameContainingIgnoreCase(String name);
    boolean existsByPhone(String phone);
    Contact findByPhone(String phone);

    @Query("SELECT c FROM Contact c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "c.phone LIKE CONCAT('%', :keyword, '%') OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Contact> searchContacts(@Param("keyword") String keyword);
}