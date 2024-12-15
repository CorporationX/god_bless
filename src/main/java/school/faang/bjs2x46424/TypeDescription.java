package school.faang.bjs2x46424;

public enum TypeDescription {
    ORIGINAL_IMAGE("Оригинальное изображение"),
    BLACK_WHITE(" | Фильтр: черно-белый"),
    SEPIA(" | Фильтр: сепия");

    private final String typeDescription;

    TypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
