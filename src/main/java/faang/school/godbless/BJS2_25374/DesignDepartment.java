package faang.school.godbless.BJS2_25374;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DesignDepartment implements Runnable{
    private final Resources marketing;
    private final Resources design;

    @Override
    public void run() {
        synchronized (design.getWritingLock()) {
            System.out.println("Design department working");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException("Sleep error");
            }
            design.addFile("Design draft");
            System.out.println("Design department add file to marketing resources");
            synchronized (marketing.getReadingLock()) {
                System.out.println("Design department work with marketing resources");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Sleep error");
                }
                marketing.viewFiles();
            }
        }
    }
}

