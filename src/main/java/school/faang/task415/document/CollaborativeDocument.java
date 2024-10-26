package school.faang.task415.document;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CollaborativeDocument {
    private Map<String, String> documentLines = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        documentLines.put(sectionId, data);
    }

    public String getData(String sectionId) {
        return documentLines.get(sectionId);
    }
    public void printAll(){
        documentLines.forEach((s, s2) -> System.out.println(s2));
    }
}
