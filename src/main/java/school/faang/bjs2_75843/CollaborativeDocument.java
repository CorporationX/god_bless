package school.faang.bjs2_75843;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private final Map<String, String> document = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data) {
        document.merge(sectionId, data, (dataOld, dataNew) -> String.format("%s\n\n%s", dataOld, dataNew));
    }

    public String getData(String sectionId) {
        String data = document.get(sectionId);
        if (data == null) {
            throw new DocumentNotFoundException(sectionId);
        }
        return data;
    }
}
