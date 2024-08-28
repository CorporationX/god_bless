package faang.school.godbless.googleDocs;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();

        DocumentSection section1 = new DocumentSection("Title", document);
        DocumentSection section2 = new DocumentSection("Chapter 1", document);
        DocumentSection section3 = new DocumentSection("Chapter 2", document);
        DocumentSection section4 = new DocumentSection("Chapter 3", document);
        DocumentSection section5 = new DocumentSection("Conclusions", document);

        Thread thread1 = new Thread(new DocumentSectionProcessor(section1, "title of the document"));
        Thread thread2 = new Thread(new DocumentSectionProcessor(section2, "content of chapter 1"));
        Thread thread3 = new Thread(new DocumentSectionProcessor(section3, "content of chapter 2"));
        Thread thread4 = new Thread(new DocumentSectionProcessor(section4, "content of chapter 3"));
        Thread thread5 = new Thread(new DocumentSectionProcessor(section5, "content of conclusions section"));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Results of processing document: ");
        System.out.println(section1.getDataFromSection());
        System.out.println(section2.getDataFromSection());
        System.out.println(section3.getDataFromSection());
        System.out.println(section4.getDataFromSection());
        System.out.println(section5.getDataFromSection());
    }
}
