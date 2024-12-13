package school.faang.sprint2.bjs_46170;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteService {
    public static String exceptionCall(String param) {
        log.error(param);
        throw new RuntimeException("Сервис недоступен");
    }

    public static String call(String string) {
        log.info("no error call");
        return string;
    }
}


