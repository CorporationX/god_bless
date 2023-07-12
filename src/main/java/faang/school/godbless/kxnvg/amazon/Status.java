package faang.school.godbless.kxnvg.amazon;

public enum Status {

    PROCESSED("Обработано"), AWAITING_CONFIRMATION("Ждет подтверждения");

    private String info;

    Status(String info) {
        this.info = info;
    }
}
