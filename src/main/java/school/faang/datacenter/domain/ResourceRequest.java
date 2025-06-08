package school.faang.datacenter.domain;

/**
 * @param load запрашиваемая нагрузка, которую необходимо распределить
 *
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public record ResourceRequest(double load) {
}
