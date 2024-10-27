package school.faang.google.docs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection section;

    public String process(String data) {
        return data.toUpperCase();
    }

    @Override
    public void run() {
        System.out.println("Обрабатываем секцию: " + section);
        section.update(this::process);
    }
}
