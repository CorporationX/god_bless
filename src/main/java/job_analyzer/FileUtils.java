package job_analyzer;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileUtils {
    public static String readResourceFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (InputStream inputStream = FileUtils.class.getResourceAsStream("/" + fileName)) {
            assert inputStream != null;
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}
