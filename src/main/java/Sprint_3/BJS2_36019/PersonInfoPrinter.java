package Sprint_3.BJS2_36019;

import java.util.List;

public class PersonInfoPrinter implements Runnable {
    private List<Person> personList;

    public PersonInfoPrinter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " is processing " + personList.size() + " people.");

        for (Person person : personList) {
            System.out.println("Thread " + threadName + " - имя : " + person.getName() +
                    ", Фамилия : " + person.getSurname() +
                    ", Место работы : " + person.getWorkplace());
        }
    }
}
