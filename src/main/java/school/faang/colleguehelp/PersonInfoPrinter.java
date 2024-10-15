package school.faang.colleguehelp;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> batch;

    @Override
    public void run() {
        batch.forEach( p ->
        System.out.println("Name: " + p.getName() + " Surname:" + p.getSurname() + " Age: " + p.getAge() + " Workplace: " + p.getWorkplace()));
    }
}
