import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        if (this.age != null) {
            return true;
        }
        return false;
    }

    public boolean hasAddress() {
        if (this.address != null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() { /*...*/ }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(this.surname);
        if (childBuilder.address == null) {
            childBuilder.setAddress(this.address);
        }
        return childBuilder;
    }

    @Override
    public String toString() {
        String address = this.address != null ? this.address : "не указан";
        String age = this.age.getAsInt() > 0 ? Integer.toString(this.age.getAsInt()) : "не указан";
        return "Person: \n { " +
                "Имя: " + this.name + "\n" +
                "Фамилия: " + this.surname + "\n" +
                "Возраст: " + age + "\n" +
                "Город: " + address + " }\n";
    }

    @Override
    public int hashCode() {
        return (this.name + "_" + this.surname + "_" + this.age.getAsInt() + "_" + this.address).hashCode();
    }
}