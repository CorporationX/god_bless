package school.faang.bjs246318;

import java.util.Objects;

public class RemoteService {
    public static String calls(String parameters) throws Exception {
        if (Objects.equals(parameters, "Very important parameters")) {
            String answer = "Response remote service: The request was successfully processed, returning result.";
            return answer;
        } else {
            throw new Exception("Remote service unavailable!");
        }
    }
}
