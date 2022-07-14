package ru.homeworks.abatsanov;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age != null ? personBuilder.age : OptionalInt.empty();
        this.address = hasAddress(personBuilder) ? personBuilder.address : setAddress("Moscow");
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress(PersonBuilder personBuilder) {
        return personBuilder.address != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getAge() {
        return hasAge() ? String.valueOf(this.age.getAsInt()) : "Возраст неизвестен";
    }

    public String getAddress() {
        return this.address;
    }

    public String setAddress(String city) {
        return this.address = city;
    }

    public void happyBirthday() {
        this.age = hasAge() ? OptionalInt.of(Integer.parseInt(getAge()) + 1) : this.age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.getSurname())
                .setAddress(this.getAddress())
                .setAge(0);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + getAge() +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
