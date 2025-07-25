package school.faang.s_4_1_amazon_order_fulfillment;

public enum Status { // public static class Status extends Enum<Status
    PENDING("В ожидании"), // public static final Status PENDING = new Status("В ожидании");
    PROCESSING("В обработке"), // public static final Status PROCESSING = new Status("В обработке");
    DONE("Обработано"), //  public static final Status DONE = new Status("Обработано");
    CANCELED("Отменено"); // public static final Status CANCELED = new Status("Отменено");

    private final String label;

    // Все конструкторы enum по умолчанию всегда private, даже если ты явно этого не указала.
    //Это правило языка Java: нельзя создавать новые значения enum извне, поэтому:
    private Status (String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
