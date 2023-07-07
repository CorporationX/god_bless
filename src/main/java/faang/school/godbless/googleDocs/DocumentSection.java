package faang.school.godbless.googleDocs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DocumentSection {
    private String ident;
    private String data;
    private CollaborativeDocument document;


    public void addData(String value){
        document.addSomething(ident, value);
    }

    public String getData(){
        return data;
    }
}
