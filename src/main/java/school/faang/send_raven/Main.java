package school.faang.send_raven;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RavenPostService service = new RavenPostService();

        Kingdom winterfell = new Kingdom("Winterfell");
        Kingdom westerlands = new Kingdom("Westerlands");

        IntStream.range(0, 20)
                .forEach(i -> service.sendRaven(westerlands, winterfell)
                        .handle((result, exception) -> {
                            if (exception != null) {
                                log.error("Message didn't get {}", exception.getMessage());
                            } else {
                                log.info(result);
                            }
                            return null;
                        })
                        .join());
    }
}
