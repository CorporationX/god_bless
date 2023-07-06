package faang.school.godbless.googleDocs;

import java.util.Scanner;

public class DocumentSectionProcessor implements  Runnable{
    private final DocumentSection documentSection;
    private final Object lock;

    public DocumentSectionProcessor(DocumentSection documentSection) {
        this.documentSection = documentSection;
        this.lock = documentSection.getDocument();
    }

    public void processNewData(String newData) {
        if (isValidData(newData)) {
            documentSection.writeContent(newData);
        } else {
            System.out.println("Invalid data! Only letters and spaces are allowed.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter valid data for section " + documentSection.getId() + ": ");
            String validData = scanner.nextLine();
            processNewData(validData);
        }
    }

    private boolean isValidData(String data) {
        return data.matches("[a-zA-Z\\s\\d]+");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String newData;

        synchronized (lock) {
            try {
                do {
                    System.out.print("Enter new data for " + documentSection.getId() + " (or 'exit' to quit): ");
                    newData = scanner.nextLine();

                    if (!newData.equalsIgnoreCase("exit")) {
                        processNewData(newData);
                    } else {
                        break;
                    }

                } while (true);
                System.out.println("Data processing for " + documentSection.getId() + " is completed");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
