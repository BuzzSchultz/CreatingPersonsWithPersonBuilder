package ru.homeworks.abatsanov;

public class Main {
    public static void main(String[] args) {

        System.out.println("Создаем объевт Person с полным набором полей");
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom);

        System.out.println("Меняем адрес объета");
        mom.setAddress("SPb");
        System.out.println(mom);

        System.out.println("У объекта появился ребенок");
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom.getName() + " есть сын, " + son);

        System.out.println("Антошке годик");
        son.happyBirthday();
        System.out.println(son);

        System.out.println("Создаем объевт Person без необязательных полей");
        Person kate = new PersonBuilder()
                .setName("Kate")
                .setSurname("Brown")
                .build();
        System.out.println(kate);

        try {
            // Не хватает обязательного поля "Имя"
            Person sam = new PersonBuilder()
                    .setSurname("Johns")
                    .setAge(20)
                    .setAddress("NY")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает обязательного поля "Фамилия"
            Person tom = new PersonBuilder()
                    .setName("Tom")
                    .setAge(22)
                    .setAddress("NY")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
