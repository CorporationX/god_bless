package school.BJS2_39382;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSection {

    private String id;
    private CollaborativeDocument document;

    public String read() {
        return document.getData(id);
    }

    public void write(String data) {
        document.addData(id, data);
    }
    public void printData() {
        System.out.println(document.getDataInfo(id) + " обработаны");
    }

    @Override
    public String toString() {
        return "DocumentSection{" +
                "id='" + id + '\'' +
                ", document=" + document +
                '}';
    }
}