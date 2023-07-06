package faang.school.godbless.googleDocs;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);

        Thread thread1 = new Thread(new DocumentSectionProcessor(section1));
        Thread thread2 = new Thread(new DocumentSectionProcessor(section2));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Data in section 1: " + section1.readContent());
        System.out.println("Data in section 2: " + section2.readContent());

        System.out.println("Data processing for all sections is completed");
    }

}
