package school.faang.bjs2_87565;

import java.util.Objects;

public class Service {
    public static String message(String mes) {
        if (Objects.isNull(mes)) {
            throw new RuntimeException("Sorry!!! Was noticed NULL");
        }
        return mes;
    }
}
