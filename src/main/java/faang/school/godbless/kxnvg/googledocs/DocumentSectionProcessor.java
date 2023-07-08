package faang.school.godbless.kxnvg.googledocs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DocumentSectionProcessor implements Runnable {

    private DocumentSection documentSection;
    private String command;


    @Override
    public void run() {
        dataHandle();
        System.out.println("Раздел " + documentSection.getId() + " изменен в соответсвии с командой: " + command);
    }

    private void dataHandle() {
        switch (command) {
            case "up":
                documentSection.setData(documentSection.getData().toUpperCase());
                documentSection.writeContent();
                break;
            case "down":
                documentSection.setData(documentSection.getData().toLowerCase());
                documentSection.writeContent();
                break;
            case "clear":
                documentSection.setData("");
                documentSection.writeContent();
                break;
            case "update":
                documentSection.setData(documentSection.getData() + " + update info");
                documentSection.writeContent();
                break;
            default:
                System.out.println("Такой команды не существует");
        }
    }
}
