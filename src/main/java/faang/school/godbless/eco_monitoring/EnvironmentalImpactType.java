package faang.school.godbless.eco_monitoring;

import lombok.Getter;

@Getter
public enum EnvironmentalImpactType {
    ENERGY_CONSUMPTION("Energy Consumption", "Consumption"),
    GAS_EMISSION("Gas Emission", "Emission");

    private final String fullTypeName;
    private final String shortTypeName;

    EnvironmentalImpactType(String fullTypeName, String shortTypeName) {
        this.fullTypeName = fullTypeName;
        this.shortTypeName = shortTypeName;
    }
}
