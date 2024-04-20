package wesley.io.restful.api.java.dto;

import java.math.BigDecimal;

public record CardDTO(
        String cardNumber,
        BigDecimal cardLimit
) {
}
