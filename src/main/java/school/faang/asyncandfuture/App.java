package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        try {
            MasterCardService service = new MasterCardService();
            service.doAll();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            log.info("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            log.info("Программа завершена.");
        }
    }
}
