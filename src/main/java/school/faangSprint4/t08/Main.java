package school.faangSprint4.t08;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");
        Kingdom highgarden = new Kingdom("Highgarden");

        log.info("Начинаем отправку сообщений...\n");

        ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.warn(exception.getMessage());
                    } else {
                        log.info(result);
                    }
                    return null;
                });

        ravenService.sendRaven(kingsLanding, highgarden)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.warn(exception.getMessage());
                    } else {
                        log.info(result);
                    }
                    return null;
                });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}