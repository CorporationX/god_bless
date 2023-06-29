package faang.school.godbless;

public class PersonNamePrinter implements Runnable {
    private Person person;

    public PersonNamePrinter(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread | " + person.getName());
    }
}
