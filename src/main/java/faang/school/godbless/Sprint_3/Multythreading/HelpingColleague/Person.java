package faang.school.godbless.Sprint_3.Multythreading.HelpingColleague;

import lombok.Getter;

@Getter
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


}
