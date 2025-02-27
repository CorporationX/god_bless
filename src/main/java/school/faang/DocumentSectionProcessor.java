package school.faang;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private final DocumentSection documentSection;

    @Override
    public void run() {
        String currentData = documentSection.read();
        documentSection.write(currentData.toUpperCase());
    }
}
