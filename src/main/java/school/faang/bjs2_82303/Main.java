package school.faang.bjs2_82303;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Kingdom kingdom = new Kingdom("Kingdom");
        Kingdom anotherKingdom = new Kingdom("Another Kingdom");

        kingdom.sendRaven(kingdom, anotherKingdom)
                .handle((message, error) -> {
                    if (error != null) {
                        log.error(error.getMessage(), error);
                        return error.getMessage();
                    }
                    log.info(message);
                    return message;
                }).join();
    }
}
