import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
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
        this.age = OptionalInt.of(age);
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
        Person person = age.isPresent() ? new Person(name, surname, age.getAsInt()) : new Person(name, surname);
        person.setAddress(address);
        return person;
    }
}
