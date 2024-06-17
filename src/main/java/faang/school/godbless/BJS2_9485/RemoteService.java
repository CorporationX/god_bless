package faang.school.godbless.BJS2_9485;

import lombok.Getter;

@Getter
public class RemoteService {
    IllegalArgumentException exception;

    public String call(String param) throws IllegalArgumentException {
        if (param.isEmpty()) {
            exception = new IllegalArgumentException("Input data is empty");
            throw exception;
        }
        System.out.println("Your parameter is " + param);
        return "Your parameter is " + param;
    }
}
