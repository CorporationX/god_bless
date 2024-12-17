package school.faang.bjs248033;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class PersonInfoPrinter implements Runnable {
    private final int startIndex;
    private final int endIndex;

    List<Person> people;

    public PersonInfoPrinter(List<Person> people, int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            //       Person person = people.get(i);
     /*       System.out.println("***");
            log.info("Name: {}, Surname: {}, Age: {}, Workplace: {}",
                    people.get(i).getName(), people.get(i).getSurname(), people.get(i).getAge(), people.get(i).getWorkplace());*/
            try {
                log.info("The data output has begun");
                log.info("Name: {}, Surname: {}, Age: {}, Workplace: {}",
                        people.get(i).getName(), people.get(i).getSurname(), people.get(i).getAge(), people.get(i).getWorkplace());
                Thread.sleep(3000);
                log.info("The data output has finished");
            } catch (InterruptedException e) {
                log.error("The thread was interrupted {} ", Thread.currentThread().getName());
            }
        }
    }
}