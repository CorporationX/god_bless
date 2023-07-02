package faang.school.godbless.Sprint4.task3;

public class PersonNamePrinter implements Runnable {
    Person person;

    public PersonNamePrinter(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println("Person workplace: " + person.getWorkplace());
    }
}
