package BJS260531;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;



    @Override
    public void run() {

        log.info("Start index : {}\n End index : {}", startIndex, endIndex);
        System.out.println("Letter is send. ");
    }
}
