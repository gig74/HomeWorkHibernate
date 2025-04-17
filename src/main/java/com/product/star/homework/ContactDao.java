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
        long contactId = 0;
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                contactId = (long) session.save(contact);
                transaction.commit();
            } catch (Exception ex) {
                // On error, revert all changes done
                if (transaction != null) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
        return contactId;
    }

    public void updatePhoneNumber(long contactId, String phoneNumber) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Contact contact = session.get(Contact.class, contactId);
                if (contact != null) {
                    contact.setPhone(phoneNumber);
                    session.update(contact);
                    transaction.commit();
                }
            } catch (Exception ex) {
                // On error, revert all changes done
                if (transaction != null) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
    }

    public void updateEmail(long contactId, String email) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Contact contact = session.get(Contact.class, contactId);
                if (contact != null) {
                    contact.setEmail(email);
                    session.update(contact);
                    transaction.commit();
                }
            } catch (Exception ex) {
                // On error, revert all changes done
                if (transaction != null) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
    }

    public void deleteContact(long contactId) {
        try (var session = sessionFactory.openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                Contact contact = session.get(Contact.class, contactId);
                if (contact != null) {
                    session.delete(contact);
                    transaction.commit();
                }
            } catch (Exception ex) {
                // On error, revert all changes done
                if (transaction != null) {
                    transaction.rollback();
                    throw ex;
                }
            }
        }
    }
}
