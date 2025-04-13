package school.faang.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info(getResponseWithContent("Музыка").content());
        log.info(getResponseWithContent("").content());
    }

    private static ServiceResponse getResponseWithContent(String contentName) {
        return ErrorHandler.withErrorHandling(
                () -> new SomeService().call(contentName),
                error -> {
                    log.warn(error.getMessage());
                    return SomeService.DEFAULT_RESPONSE;
                }
        );
    }
}