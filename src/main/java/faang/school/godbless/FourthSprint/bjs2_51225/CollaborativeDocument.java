package faang.school.godbless.FourthSprint.bjs2_51225;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

public class CollaborativeDocument {
    private ConcurrentHashMap<String, String> document = new ConcurrentHashMap<>();

    public void addData(String sectionId, String data){
        document.put(sectionId, data);
    }

    public String getData(String sectionId){
        return document.getOrDefault(sectionId, "this section doesn't exist");
    }
}
