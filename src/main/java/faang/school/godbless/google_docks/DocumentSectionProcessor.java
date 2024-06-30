package faang.school.godbless.google_docks;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection documentSection;
    private Function<String, String> modification;

    @Override
    public void run() {
        documentSection.modifySectionData(modification);
        log.info(documentSection.getId() + " was modified");
    }
}
