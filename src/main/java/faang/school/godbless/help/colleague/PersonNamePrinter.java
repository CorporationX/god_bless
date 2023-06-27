package faang.school.godbless.help.colleague;

public class PersonNamePrinter implements Runnable {
    Person person;

    @Override
    public void run() {
        System.out.println(person.name());
    }
}
