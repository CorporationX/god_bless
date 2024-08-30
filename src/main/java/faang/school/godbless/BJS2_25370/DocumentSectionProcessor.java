package faang.school.godbless.BJS2_25370;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection documentSection;

    @Override
    public void run() {
        synchronized (documentSection) {
            String content = documentSection.clear();
            documentSection.write(content.toUpperCase());
        }
    }
}