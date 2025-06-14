package school.faang.bjs2_80164;

public class Main {
    public static void main(String[] args) {
        // Здесь вызываем с обработкой ошибок
        String result = ErrorHandler.withErrorHandling(
                () -> FromSoftware.call("соулслайк хочу нормальный "),
                e -> {
                    System.out.println("error..xd " + e.getMessage());
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class FromSoftware {
        public static String call(String param) {
            System.out.println("Вызов FromSoftware с параметром: " + param);
            throw new RuntimeException("фиг тебе а не нормальный соулслайк");
        }
    }
}
