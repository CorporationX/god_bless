package faang.school.godbless.FourthSprint.bjs2_51225;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private DocumentSection documentSection;

    public String process(String data) {
        String processedData = data.toUpperCase();
        documentSection.write(processedData);
        return processedData;
    }
    @Override
    public void run() {
        process(documentSection.read());
    }
}
