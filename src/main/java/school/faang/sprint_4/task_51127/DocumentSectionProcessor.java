package school.faang.sprint_4.task_51127;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection documentSection;

    @Override
    public void run() {
        String data = documentSection.read();
        documentSection.write(process(data));
    }

    public String process(String data) {
        return data.toUpperCase();
    }
}
