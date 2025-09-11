package school.faang.module2.error_handle;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class RestService {

    public static <T> T callWithErrorHandling(AccessToken accessToken, String jsonRequest, Class<T> mappedClass) {
        return handle(
                () -> RestClient.call(accessToken, jsonRequest, mappedClass),
                e -> {
                    System.out.printf("Exception was thrown: %s%n", e);
                    return RestClient.call(getNewAccessToken(), jsonRequest, mappedClass);
                }
        );
    }

    private static AccessToken getNewAccessToken() {
        return new AccessToken(LocalDate.now().plusDays(1));
    }

    private static <T> T handle(Supplier<T> requestSupplier, Function<AuthorizationException, T> responseMapper) {
        try {
            return requestSupplier.get();
        } catch (AuthorizationException e) {
            return responseMapper.apply(e);
        }
    }
}
