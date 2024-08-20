package faang.school.godbless.HandlingErrorsGracefully;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandlingUtil.withErrorHandling(
                () -> remoteServiceCall("param"),
                (Exception e) -> {
                    System.out.println("Failed to call remote service, returning default value.");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
    private static String remoteServiceCall(String param) {
        if (param.equals("fail")) {
            throw new RuntimeException("Remote service failed");
        }
        return "Success";
    }
}
