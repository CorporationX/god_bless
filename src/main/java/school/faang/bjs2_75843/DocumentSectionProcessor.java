package school.faang.bjs2_75843;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    @Override
    public void run() {
        String data = section.getId() + " data";
        section.write(process(data));
        String readData = section.read();
        log.info("Read data {}", readData);
    }

    public String process(String data) {
        return data.toUpperCase();
    }
}
