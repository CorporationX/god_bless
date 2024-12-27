package school.faang.task51147;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection section;

    public String processData(String data) {
        Objects.requireNonNull(data);

        return data.toUpperCase();
    }

    @Override
    public void run() {
        section.write(processData(section.read()));
        log.info("Обработанные данные: {}", section.read());
    }
}
