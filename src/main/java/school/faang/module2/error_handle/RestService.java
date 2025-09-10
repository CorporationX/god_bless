package school.faang.module2.error_handle;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class RestService {

    public static <T> T callWithErrorHandling(AccessToken accessToken, String jsonRequest, Class<T> mappedClass) {
        return handle(
                () -> RestClient.call(accessToken, jsonRequest, mappedClass),
                r -> RestClient.call(getNewAccessToken(), jsonRequest, mappedClass)
        );
    }

    private static AccessToken getNewAccessToken() {
        return new AccessToken(LocalDate.now().plusDays(1));
    }

    private static <T> T handle(Supplier<T> requestSupplier, Function<T, T> responseMapper) {
        T reponse;
        try {
            reponse = requestSupplier.get();
            return reponse;
        } catch (AuthorizationException e) {
            reponse = responseMapper.apply(null);
        }

        return reponse;
    }
}
