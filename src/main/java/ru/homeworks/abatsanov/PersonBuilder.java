package ru.homeworks.abatsanov;

import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Поле \"Возраст\" не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Не заполнено обязательное поле \"Имя\"");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Не заполнено обязательное поле \"Фамилия\"");
        }
        return new Person(this);
    }
}
