package school.faang.googledocs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection section;

    private void process(String data) {
        String processSection = data.toUpperCase();
        log.info("Обработали данные в разделе {}", section.getId());
        section.write(processSection);
    }

    @Override
    public void run() {
        String newData = section.read();
        process(newData);
    }
}
