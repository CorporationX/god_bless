package school.faang.fourthStream.BJS2_37902;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom kingsLanding = new Kingdom("King's Landing");

        for (int i = 1; i <= 10; i++) {
            ravenService.sendRaven(winterfell, kingsLanding);
        }

        ravenService.shutdown();
    }
}
