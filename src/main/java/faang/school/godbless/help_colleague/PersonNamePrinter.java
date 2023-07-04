package faang.school.godbless.help_colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {

    private List<Person> employees;

    @Override
    public void run() {
        for (var employee : employees) {
            System.out.println(employee.getWorkplace());
        }
    }
}
