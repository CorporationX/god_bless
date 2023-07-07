package faang.school;

public class App {
    public static void main(String[] args) {
        CollaborativeDocument document = new CollaborativeDocument();
        document.addData("section1", "text1");
        document.addData("section2", "text2");

        DocumentSection section1 = new DocumentSection("section1", document);
        DocumentSection section2 = new DocumentSection("section2", document);

        DocumentSectionProcessor processor1 = new DocumentSectionProcessor(section1);
        DocumentSectionProcessor processor2 = new DocumentSectionProcessor(section2);

        var thread1 = new Thread(processor1);
        var thread2 = new Thread(processor2);
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
