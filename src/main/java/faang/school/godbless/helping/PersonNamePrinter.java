package faang.school.godbless.helping;

import java.util.List;

public class PersonNamePrinter implements Runnable{
    List<Person> persons;

    public PersonNamePrinter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void run(){
        persons.forEach(person -> System.out.println(person.getName()));
    }
}
