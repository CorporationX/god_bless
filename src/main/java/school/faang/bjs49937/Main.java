package school.faang.bjs49937;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } catch (Exception e) {
            log.info("Error while testing {}", e.getMessage());
        }
    }
}
