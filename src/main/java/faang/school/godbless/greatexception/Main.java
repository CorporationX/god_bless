package faang.school.godbless.greatexception;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int param = 1;
        Consumer<RemoteService> consumer = remoteService -> remoteService.call(param);
    }

    public void withErrorHandling(Consumer consumer, Function function) {
//        try {
//            consumer.accept();
//        }
    }
}
