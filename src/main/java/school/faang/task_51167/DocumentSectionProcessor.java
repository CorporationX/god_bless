package school.faang.task_51167;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private DocumentSection section;

    @Override
    public void run() {

        String existingData = section.read();
        log.info("Существующие данные: " + existingData);

        String processedData = process(existingData);
        log.info("Обработанные данные: " + processedData);

        section.write(processedData);

        String updatedData = section.read();
        log.info("Обновленные данные: " + updatedData);
    }


    public String process(String data) {
        return data.toUpperCase();
    }
}
