package school.faang.task415.document;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {
    private DocumentSection documentSection;

    public void process(String data) {
        String newData = data.toUpperCase();
        documentSection.write(newData);
    }

    @Override
    public void run() {
        String string = documentSection.read();
        process(string);
        System.out.println("Обработана строка " + string);
    }
}
