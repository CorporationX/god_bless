package school.faang.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info(getResponse(new Request("{method:GET}")).body());
        log.info(getResponse(new Request("")).body());
    }

    private static Response getResponse(Request request) {
        Service service = new Service();
        return ErrorHandler.withErrorHandling(
                () -> service.get(request),
                error -> {
                    log.warn(error.getMessage());
                    return Service.DEFAULT_RESPONSE;
                }
        );
    }
}
