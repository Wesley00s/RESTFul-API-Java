package wesley.io.restful.api.java.dto;

import java.math.BigDecimal;

public record AccountDTO(
        String accountNumber,
        String agency,
        BigDecimal balance,
        BigDecimal accountLimit
) {
    
}
