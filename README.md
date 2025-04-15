# HomeWorkHibernate
 Домашнее задание по теме "Hibernate. ORM – нет времени писать запросы" (ProductStar)

# Постановка задачи
В выданном проекте необходимо дописать код так, чтобы все тесты были пройдены.
## Требования
Вспоминаем приложение для управления базой данной контактов (Урок Spring REST).
- Контакт имеет следующие характеристики – Имя и Фамилия, Телефонный номер, Email.
- Приложение должно содержать bean ContactDao, который реализует следующие операции - получение всех контактов, получение контакта по идентификатору, добавление контакта (при создании контакту присваивается идентификатор), обновление телефонного номера, обновление email, удаление контакта по идентификатору.
- ContactDao взаимодействует с локально развернутой Postgres базой данных и использует Hibernate.

## Подключенные зависимости и плагины
- hibernate-core - библиотека популярного framework для ORM (связывание ООП и реляционную базу данных.)
- spring-context - Spring Context предоставляет доступ к сконфигурированным объектам, таким как реестр (контекст).
- postgresql - PostgreSQL JDBC drive
- spring-test -  это фреймворк для модульного и интеграционного тестирования компонентов Spring с помощью JUnit
- assertj-core - это артефакт библиотеки AssertJ для тестирования (нужен для assertThat и тд)
- junit-jupiter - библиотеки для unit-тестов.

## Описание основных файлов
- main/java/com/product/star/homework/ContactDao.java - основные методы уровня DAO
- main/java/com/product/star/homework/Contact.java - класс объекта одного контакта
- main/java/com/product/star/homework/ContactConfiguratuion.java - файл основной конфигурации Spring
- main/java/com/product/star/homework/ContactMain.java - дополнительный исполняемый файл для небольшого отладочного прогона
- main/resources/hibernate.cfg.xml - файл описания соединения с БД для Hibernate
- test/java/com/product/star/homework/ContactDaoTests.java - непосредственно класс теста, который должен отработать для сдачи задания

## Примечания
- Для доработки и сдачи домашнего задания перенёс модуль spring-hibernate в отдельный проект HomeWorkHibernate
- Часть классов, относящуюся к уроку, перенёс в package com.product.star.lesson чтоб не мешалась и не пересекалась
- Для успешной отработки теста необходима локально установленная и запущенная на порту 5432 БД PostgreSQL с DB postgres и пользователем postgres с паролём postgres 
- В build.gradle поменял версию spring-context c 5.3.3 на 6.2.0 (более новую). Часть проблем ушло .
- В ContactDaoTests поменял обращение к методу с updatePhone на updatePhoneNumber (как определено в ContactDao).