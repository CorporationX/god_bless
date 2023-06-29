package faang.school.godbless.multithreading.parallelism_thread.help_colleague;

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
