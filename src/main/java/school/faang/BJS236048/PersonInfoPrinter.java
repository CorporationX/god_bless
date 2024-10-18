package school.faang.BJS236048;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> personList ;

    @Override
    public void run() {
        personList.forEach(person -> {
            try {
                Thread.sleep(500);
                System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge() + " " + person.getWorkPlace());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An error occurred while processing person: " + e.getMessage());
            }
        });
    }
}
