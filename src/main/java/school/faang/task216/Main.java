package school.faang.task216;

import school.faang.task216.errorhandler.ErrorHandler;

public class Main {
    public static void main(String[] args) {
        ErrorHandler.withErrorHandling(()->ClassForTest.call("BlaBla"),
                e -> {
                System.out.println("ошибка");
                return "default";}
        );
    }
}
