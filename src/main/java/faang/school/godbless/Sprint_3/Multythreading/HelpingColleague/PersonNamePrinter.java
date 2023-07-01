package faang.school.godbless.Sprint_3.Multythreading.HelpingColleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person>  list;

    public PersonNamePrinter(List<Person> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(Person person : list) {
            System.out.println(person.getID());
        }
    }
}
