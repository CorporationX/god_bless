package multithreading.theywereverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {

    private String work;


    @Override
    public void run() {
        System.out.println("Work " + work + " in process in thread: " + Thread.currentThread().getName());

    }
}

