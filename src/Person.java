import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
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
        return this.age.isPresent();
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
        // вернем либо возраст, либо пустой экземпляр OptionalInt
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge())
            OptionalInt.of(this.age.getAsInt()+1);
    }

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
        String address = this.hasAddress() ? this.address : "не указан";
        String age = this.hasAge() ? Integer.toString(getAge().getAsInt()) : "не указан";
        return "Person: \n{\n" +
                "Имя: " + this.name + "\n" +
                "Фамилия: " + this.surname + "\n" +
                "Возраст: " + age + "\n" +
                "Город: " + address + "\n}\n";
    }

    @Override
    public int hashCode() {
        return (this.name + "_" + this.surname + "_" + (hasAge() ? getAge() : 0) + "_" + this.address).hashCode();
    }
}