package school.faang.collection.hogwarts.spell;

public enum SpellType {

    CURSE("Проклятие"),
    ATTACK("Атака"),
    DEFENCE("Защита"),
    TRANSFIGURATION("Трансфигурация");

    private final String typeName;


    SpellType(String name) {
        this.typeName = name;
    }

    @Override
    public String toString() {
        return typeName;
    }
}