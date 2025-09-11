package school.faang.module2.error_handle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.time.LocalDate;

public class RestClient {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T call(AccessToken accessToken, String jsonRequest, Class<T> mappedClass) {
        if (accessToken.expirationDate().isBefore(LocalDate.now())) {
            throw new AuthorizationException("Access token expired");
        }

        try {
            return MAPPER.readValue(jsonRequest, mappedClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
