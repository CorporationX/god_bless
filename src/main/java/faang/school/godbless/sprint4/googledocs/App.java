package faang.school.godbless.sprint4.googledocs;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        document.documents.put("section1", "test text");
        document.documents.put("section2", "hello from section 2");

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1);
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2);

        Thread thread1 = new Thread(processor1);
        Thread thread2 = new Thread(processor2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(section1.readContent());
        System.out.println(section2.readContent());
    }
}
