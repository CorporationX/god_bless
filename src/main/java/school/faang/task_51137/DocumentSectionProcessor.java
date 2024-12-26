package school.faang.task_51137;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection documentSection;

    @Override
    public void run() {
        String data = documentSection.read();
        String newData = process(data);
        documentSection.write(newData);

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            log.error("Ошибка выполения потока{}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private String process(String data) {
        StringBuilder newData = new StringBuilder();

        for (char c : data.toCharArray()) {
            newData.append(Character.toUpperCase(c));
        }

        return newData.toString();
    }
}
