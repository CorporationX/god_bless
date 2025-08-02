package school.faang.testThread001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {
        log.info("main start");
        new Thread(new TestThread001("new task")).start();
        log.info("main end");
    }
}
