package faang.school.godbless.Sprint4.Task_3_HelpYourColleague;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public String getName() {
        return name;
    }
    public String getWorkplace() {
        return workplace;
    }

    public Person(String name, String surname, int age, String workplace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
    }
}
