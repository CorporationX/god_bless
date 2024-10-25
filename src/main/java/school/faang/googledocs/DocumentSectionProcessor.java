package school.faang.googledocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private final DocumentSection section;
    private final String data;

    public void process(String data) {
        section.write(data.toUpperCase());
    }

    @Override
    public void run() {
        process(data);

        String content = section.read();
        System.out.println("Processed data in section '" + section.getId() + "': " + content);
    }
}
