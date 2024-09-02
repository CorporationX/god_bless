package faang.school.godbless.BJS2_25374;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MarketingDepartment implements Runnable{
    private final Resources marketing;
    private final Resources design;

    @Override
    public void run() {
        synchronized (marketing.getWritingLock()) {
            System.out.println("Marketing department working");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException("Sleep error");
            }
            marketing.addFile("Results of market and competitor research");
            System.out.println("Marketing department add file to marketing resources");
            synchronized (design.getReadingLock()) {
                System.out.println("Marketing department work with design resources");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Sleep error");
                }
                design.viewFiles();
            }
        }
    }
}
