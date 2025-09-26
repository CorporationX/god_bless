package school.faang.bjs2_93381;

import java.util.Map;

public class App {
    public static void main(String[] args) throws InterruptedException {
        CollaborativeDocument document = new CollaborativeDocument();
        document.getSections().put("Section One", "Value One");
        document.getSections().put("Section Two", "Value Two");
        document.getSections().put("Section Three", "Value Three");

        Thread threadOne = new Thread(new DocumentSectionProcessor(new DocumentSection("Section One", document)));
        Thread threadTwo = new Thread(new DocumentSectionProcessor(new DocumentSection("Section Two", document)));
        Thread threadThree = new Thread(new DocumentSectionProcessor(new DocumentSection("Section Three", document)));

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();

        for (Map.Entry<String, String> entry : document.getSections().entrySet()) {
            System.out.printf("Section name: %s, Section Value: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
