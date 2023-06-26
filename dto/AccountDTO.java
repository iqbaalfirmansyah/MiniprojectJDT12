package id.co.indivara.jdt12.banklatihan.miniproject.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record AccountDTO(Long id, String address, String type, BigDecimal balance) {
}
