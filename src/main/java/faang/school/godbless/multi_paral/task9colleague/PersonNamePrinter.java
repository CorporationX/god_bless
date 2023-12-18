package faang.school.godbless.multi_paral.task9colleague;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonNamePrinter implements Runnable {
    List<Person> people;
    boolean name;
    boolean surname;
    boolean age;
    boolean workplace;

    @Override
    public synchronized void run() {
        StringBuilder sb = new StringBuilder();

        for (Person per : people) {
            if (name) {
                sb.append(per.getName()).append(" ");
            }
            if (surname) {
                sb.append(per.getSurname()).append(" ");
            }
            if (age) {
                sb.append(per.getAge()).append(" ");
            }
            if (workplace) {
                sb.append(per.getWorkplace()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
