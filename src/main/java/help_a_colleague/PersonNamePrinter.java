package help_a_colleague;

import java.util.List;

public class PersonNamePrinter implements Runnable{
    private List<Person> people;
    public PersonNamePrinter(List<Person> people){
        this.people = people;
    }
    public void run(){
        for(var person: people){
            System.out.println(person.getName());
        }
    }
}
