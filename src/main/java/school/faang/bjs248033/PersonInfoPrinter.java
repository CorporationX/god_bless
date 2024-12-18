package school.faang.bjs248033;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

@Slf4j
@Getter
public class PersonInfoPrinter implements Runnable {
    private final int startIndex;
    private final int endIndex;

    ExecutorService executorService;

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
 /*           try {
                log.info("The data output has begun");
                log.info("Name: {}, Surname: {}, Age: {}, Workplace: {}",
                        people.get(i).name(), people.get(i).surname(), people.get(i).age(), people.get(i).workplace());
                Thread.sleep(3000);
                log.info("The data output has finished");
            } catch (InterruptedException e) {
                log.error("The thread was interrupted {} ", Thread.currentThread().getName());
            }
  //      }*/
        }
    }
}