package id.co.indivara.jdt12.banklatihan.miniproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.banklatihan.miniproject.dto.CostumerDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;
import id.co.indivara.jdt12.banklatihan.miniproject.repo.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CostumerServiceImpl implements CostumerService{

    @Autowired
    CostumerRepository costumerRepository;
    @Override
    public Costumer create(Costumer costumer) {
        final Costumer result = costumerRepository.save(costumer);
        return result;
    }

    @Override
    public Costumer update(Long id, Costumer costumer) {
        Costumer result = findById(id);
        if (result !=null){
            result.setName(costumer.getName());
            return costumerRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Costumer result = findById(id);
        if (result !=null){
            costumerRepository.deleteById(id);
            return true;
        }
return false;
    }

    @Override
    public List<Costumer> findAll() {
        return costumerRepository.findAll();
    }

    @Override
    public Costumer findById(Long id) {
        Optional<Costumer> result = costumerRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public CostumerDTO mapToDTO(Costumer costumer) {
        return mapper.convertValue(costumer, CostumerDTO.class);
    }

    @Override
    public Costumer mapToEntity(CostumerDTO costumerDTO) {
        return mapper.convertValue(costumerDTO, Costumer.class);
    }
}
