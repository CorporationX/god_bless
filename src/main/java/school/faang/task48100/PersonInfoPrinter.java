package school.faang.task48100;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {

    private Person person;


    @Override
    public void run() {
        log.info(person.getName() + " " + person.getSurname() + " " + person.getAge() + " "
                + person.getWorkplace());
    }
}
