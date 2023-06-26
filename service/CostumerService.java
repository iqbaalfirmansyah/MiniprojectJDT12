package id.co.indivara.jdt12.banklatihan.miniproject.service;

import id.co.indivara.jdt12.banklatihan.miniproject.dto.CostumerDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;

import java.util.List;

public interface CostumerService {
    Costumer create(Costumer costumer);
    Costumer update(Long id, Costumer costumer);
    Boolean delete(Long id);
    List<Costumer> findAll();
    Costumer findById(Long id);

    CostumerDTO mapToDTO (Costumer costumer);
    Costumer mapToEntity (CostumerDTO costumer);
}
