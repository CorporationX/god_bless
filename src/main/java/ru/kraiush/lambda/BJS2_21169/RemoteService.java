package ru.kraiush.lambda.BJS2_21169;

import java.util.List;
import java.util.stream.Collectors;

public class RemoteService {

    public static List<Object> withErrorHandling(List<SomeService> listServices, String param) {

        Actionhandler<String, List<Object>> apply= (item) -> {
            return listServices.stream().map(ErrorHandler.rethrowFunction(s -> s.getName())).filter(s -> s.equals(item)).collect(Collectors.toList());
        };

        List<Object> result = apply.apply(param);
        return result;
    }

}
