package school.faang.bjs246205;

public class Main {

    public static void main(String[] args) {

        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return FileUpload.uploadFile("C:\\data.txt");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.err.println("Error during file uploading, return default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}