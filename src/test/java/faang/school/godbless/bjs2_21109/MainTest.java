package faang.school.godbless.bjs2_21109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testWithErrorHandling() {
        var service = new Service();
        var stringResult = Main.withErrorHandling(() -> service.call("string"), (exception) -> {
            System.out.println(exception.getMessage());
            return "DEFAULT";
        });
        assertEquals("string", stringResult);

        var exceptionResult = Main.withErrorHandling(() -> service.call(null), (exception) -> {
            System.out.println(exception.getMessage());
            return "DEFAULT";
        });
        assertEquals("DEFAULT", exceptionResult);
    }
}

class Service {
    public String call(String param) {
        return param.toString();
    }
}