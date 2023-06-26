package id.co.indivara.jdt12.banklatihan.miniproject.dto;

import java.math.BigDecimal;
import java.util.List;

public record CostumerDTO(Long id, String name, String email, String address, String handphone , List<AccountDTO> accounts){
}
