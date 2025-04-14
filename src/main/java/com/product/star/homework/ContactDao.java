package com.product.star.homework;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class ContactDao {

    private final SessionFactory sessionFactory;

    public ContactDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Contact> getAllContacts() {
        try (var session = sessionFactory.openSession()) {
            var query = session.createQuery("from Contact");
            return query.getResultList();
        }
    }

    public Contact getContact(long contactId) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Contact.class, contactId);
        }
    }

    public long addContact(Contact contact) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            long contactId = (long) session.save(contact);
            transaction.commit();
            return contactId;
        }
    }

    public void updatePhoneNumber(long contactId, String phoneNumber) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, contactId);
            if (contact != null) {
                contact.setPhone(phoneNumber);
                session.update(contact);
                transaction.commit();
            }
        }
    }

    public void updateEmail(long contactId, String email) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, contactId);
            if (contact != null) {
                contact.setEmail(email);
                session.update(contact);
                transaction.commit();
            }
        }
    }

    public void deleteContact(long contactId) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, contactId);
            if (contact != null) {
                session.delete(contact);
                transaction.commit();
            }
        }
    }
}
