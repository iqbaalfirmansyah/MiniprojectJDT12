package id.co.indivara.jdt12.banklatihan.miniproject.controller;

import id.co.indivara.jdt12.banklatihan.miniproject.dto.CostumerDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;
import id.co.indivara.jdt12.banklatihan.miniproject.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    CostumerService costumerService;

    @PostMapping("/create")
    public CostumerDTO create(@RequestBody CostumerDTO request){
        final Costumer costumer = costumerService.mapToEntity(request);
        final Costumer result = costumerService.create(costumer);
        return costumerService.mapToDTO(result);
    }

    @PutMapping("/update/{id}")
    public CostumerDTO update( @PathVariable Long id , @RequestBody CostumerDTO request){
        final Costumer costumer = costumerService.mapToEntity(request);
        Costumer result = costumerService.update(id, costumer);
        return costumerService.mapToDTO(result);
    }

    @GetMapping("/all")
    public List<CostumerDTO> findAll(){
        return costumerService.findAll().stream().map(costumer -> costumerService.mapToDTO(costumer))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return costumerService.delete(id);
    }
}
