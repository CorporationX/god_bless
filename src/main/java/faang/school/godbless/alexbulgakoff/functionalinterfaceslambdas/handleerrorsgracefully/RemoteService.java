package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.handleerrorsgracefully;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alexander Bulgakov
 */

@AllArgsConstructor
@Getter
public class RemoteService {

    private int status;
    public String call(int status) throws Exception {
        return "Connect is lost";
    }
}
