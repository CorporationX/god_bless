package school.faang.module2.error_handle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class RestServiceTest {

    private final AccessToken expiredToken = new AccessToken(LocalDate.now().minusDays(1));
    private final AccessToken validToken = new AccessToken(LocalDate.now().plusDays(1));

    @Test
    void restServiceTest() {
        String userAsString = """
                {
                    "user": "Mike"
                }
                """;
        String messageAsString = """
                {
                    "message": "Success"
                }
                """;

        UserDto userDto = RestService.callWithErrorHandling(validToken, userAsString, UserDto.class);
        userDto = RestService.callWithErrorHandling(expiredToken, userAsString, UserDto.class);

        Assertions.assertEquals("Mike", userDto.user());

        MessageDto messageDto = RestService.callWithErrorHandling(validToken, messageAsString, MessageDto.class);
        messageDto = RestService.callWithErrorHandling(validToken, messageAsString, MessageDto.class);

        Assertions.assertEquals("Success", messageDto.message());
    }

}