package com.product.star.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContactMain {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(ContactConfiguration.class);

        var contactDao = applicationContext.getBean(ContactDao.class);
        contactDao.addContact(new Contact("Maria", "Ivanova", "mivanova@gmail.com", "7654321"));
        var contact = contactDao.getContact(1L);
        System.out.println(contact);
    }
}
