package faang.school.godbless.google_docks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

@Getter
@ToString
@AllArgsConstructor
public class DocumentSection {
    private String id;
    private CollaborativeDocument documentReference;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void modifySectionData(Function<String, String> modification) {
        String sectionData = getDataFromDocument();

        readWriteLock.writeLock().lock();
        try {
            sectionData = modification.apply(sectionData);
            documentReference.addData(id, sectionData);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String readSectionData() {
        readWriteLock.readLock().lock();
        try {
            return getDataFromDocument();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private String getDataFromDocument() {
        return documentReference.getData(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not find section by data"));
    }
}
