package id.co.indivara.jdt12.banklatihan.miniproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.indivara.jdt12.banklatihan.miniproject.dto.AccountDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Account;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;
import id.co.indivara.jdt12.banklatihan.miniproject.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    CostumerService costumerService;

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account addAccount(Long costumerId, Account account) {
        final Costumer costumer = costumerService.findById(costumerId);
        if (costumer != null){
            account = accountRepository.save(account);
            if (costumer.getAccounts() != null){
                List<Account> accounts = costumer.getAccounts();
                accounts.add(account);
                costumer.setAccounts(accounts);
            } else {
                costumer.setAccounts(Collections.singletonList(account));
            }
        }
        costumerService.create(costumer);
        return account;
    }

    @Override
    public Account deposit(Long costumerId, Account account) {
        Account result = findById(costumerId);
        if (result !=null){
            result.setBalance(account.getBalance());
            return accountRepository.save(result);
        }
        return null;
    }



    @Override
    public Boolean delete(Long id) {
        final Account result = findById(id);
        if (result !=null){
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> result = accountRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Account mapToEntity(AccountDTO accountDTO) {
        return mapper.convertValue(accountDTO, Account.class);
    }

    @Override
    public AccountDTO mapToDto(Account account) {
        return mapper.convertValue(account, AccountDTO.class);
    }
}
