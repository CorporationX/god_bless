package school.faang.send_a_raven.main;

import school.faang.send_a_raven.main_code.Kingdom;
import school.faang.send_a_raven.main_code.RavenService;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        Kingdom firstKingdom = new Kingdom("firstKingdom");
        Kingdom secondKingdom = new Kingdom("secondKingdom");

        ravenService.sendRaven(firstKingdom, secondKingdom)
                        .handle((result, exception) -> {
                            if (exception != null) {
                                System.out.println("возникла ошибка " + exception.getMessage());
                            } else {
                                System.out.println(result);
                            }
                            return null;
                        }).join();

        ravenService.shutdown();
    }
}
