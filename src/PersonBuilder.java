import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        // если возраст слишком уж большой или отрицательный - выбрасываем исключение
        if (age > 110 || age < 0) {
            throw new IllegalArgumentException("Неверно указан возраст");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        // если имя или фамилия не указаны - выбрасываем исключение
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Имя и фамилия - обязательные параметры");
        }
        Person person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
