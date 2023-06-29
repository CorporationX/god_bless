package faang.school.godbless.multithreading.parallelism_thread.help_colleague;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    private List<Person> employees;

    public PersonNamePrinter(List<Person> nameList) {
        this.employees = nameList;
    }

    @Override
    public void run() {
        employees.forEach(employee -> System.out.println(employee.getName()));
    }
}
