package faang.school.godbless.sprint2.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

@Data
@AllArgsConstructor
public class TestService {

    public String getResultWithoutException() {
        return "OK";
    }

    public String getResultWithException() throws Exception {
        if (0 == 0) {
            throw new Exception("Test exception");
        }

        return "";
    }
}
