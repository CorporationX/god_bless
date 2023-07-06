package faang.school.godbless.sprint5.multithreading_conc.task2_google;

public class DocumentSectionProcessor implements Runnable {


    private final DocumentSection section;

    public DocumentSectionProcessor(DocumentSection section) {
        this.section = section;
    }

    @Override
    public void run() {
        String currentSection = this.section.get();
        this.section.add(currentSection.toUpperCase());
        System.out.println("Раздел :" + section.getId() + " отформатирован в верхний регистр " + section.get());
    }
}
