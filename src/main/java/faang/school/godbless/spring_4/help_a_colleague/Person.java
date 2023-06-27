package faang.school.godbless.spring_4.help_a_colleague;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(String name, String surname, int age, String workplace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(workplace, person.workplace);
    }

    @Override
    public String toString() {
        return "name: " + name + " surname: " + surname + " age: " + age + " workplace: " + workplace;
    }

    @Override
    public int hashCode() {
        int num = 31;
        return num * Objects.hash(name, surname, age, workplace);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
}

