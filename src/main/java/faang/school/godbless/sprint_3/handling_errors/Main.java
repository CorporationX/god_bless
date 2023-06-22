package faang.school.godbless.sprint_3.handling_errors;

import java.util.List;
import java.util.function.Supplier;

public class Main {
    List<String> ordersList = List.of("Duck", "Bread", "Bottle of water", "Soap", "Eggs");

    public static void main(String[] args) {
        Main main = new Main();
        String firstBuy = withErrorHandling(() -> main.getOrder(3), exception -> {
            exception.printStackTrace();
            return "Bottle of water";
        });
        System.out.println(firstBuy);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.accept(e);
        }
    }

    public String getOrder(int index) {
        return ordersList.get(index);
    }
}