package school.faang.help_the_college;

import java.util.List;

public class PersonInfoPrinter implements Runnable {

    private final List<Person> people;

    public PersonInfoPrinter(List<Person> people) {
        this.people = people;
    }


    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(
                    "Имя: " + person.getName() +
                            ", Фамилия: " + person.getSurname() +
                            ", Место работы: " + person.getWorkplace()
            );
        }
    }
}
