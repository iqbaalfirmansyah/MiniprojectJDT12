package id.co.indivara.jdt12.banklatihan.miniproject.dto;

import java.util.List;

public record CostumerDTO(Long id, String name, List<AccountDTO> accounts){
}
