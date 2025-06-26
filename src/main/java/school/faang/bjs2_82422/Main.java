package school.faang.bjs2_82422;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            MasterCardService.doAll();
        } catch (Exception e) {
            log.error("ошибка damn");
            throw new RuntimeException();
        }
    }
}
