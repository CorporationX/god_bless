package faang.school.godbless.task.multithreading.async.async.and.future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static final MasterCardService masterCardService = new MasterCardService();

    public static void main(String[] args) {
        masterCardService.doAll();
        log.info("End");
    }
}
