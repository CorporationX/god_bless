package faang.school.godbless.modul4.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService(Executors.newCachedThreadPool());
        masterCardService.doAll();
    }
}
