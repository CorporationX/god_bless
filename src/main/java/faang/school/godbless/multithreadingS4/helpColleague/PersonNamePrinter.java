package faang.school.godbless.multithreadingS4.helpColleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private List<Person> persons;

    @Override
    public void run() {
        for (var person : persons){
            System.out.println(person);
        }
    }
}
