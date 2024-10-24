package school.faang.googledocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable{
    private DocumentSection section;

    @Override
    public void run() {
        String currentData = section.read();
        section.write(process(currentData));
        System.out.println("Обработанные данные для раздела " + section.read());
    }

    public String process(String data) {
        return data.toUpperCase();
    }
}
