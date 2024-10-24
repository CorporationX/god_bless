package sprint_4.sprint_4_1_async_future.sendRaven_37917;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        ravenService.sendRaven(winterfell, kingsLanding)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.error("Error: {}", exception.getMessage());
                    }
                    log.info(result);
                    return null;
                })
                .join();
    }
}
