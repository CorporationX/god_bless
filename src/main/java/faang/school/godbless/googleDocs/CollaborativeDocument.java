package faang.school.godbless.googleDocs;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;
@Getter
public class CollaborativeDocument {
    private ConcurrentHashMap<String, String> document = new ConcurrentHashMap<>();
    public void addSomething(String key, String value){
        this.document.put(key, value);
    }

    public String getFromDocument(String key){
        return document.get(key);
    }

}
