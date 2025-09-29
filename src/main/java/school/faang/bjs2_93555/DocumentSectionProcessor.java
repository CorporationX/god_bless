package school.faang.bjs2_93555;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection section;


    public void process(String data) {
        section.write(data.toUpperCase());
    }

    @Override
    public void run() {
        String newData = section.read();
        process(newData);
        log.info("Данные перезаписаны: {}", newData);
    }
}
