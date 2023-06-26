package id.co.indivara.jdt12.banklatihan.miniproject.controller;


import id.co.indivara.jdt12.banklatihan.miniproject.dto.AccountDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.dto.CostumerDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Account;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;
import id.co.indivara.jdt12.banklatihan.miniproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping("/add/{costumerId}")
    public AccountDTO addAccountToCostumer(@PathVariable Long costumerId, @RequestBody AccountDTO request){
        final Account account = accountService.mapToEntity(request);
        final Account result = accountService.addAccount(costumerId, account);
        return accountService.mapToDto(result);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return accountService.delete(id);
    }

    @PostMapping("/deposit/{accountId}")
    public AccountDTO update(@PathVariable Long accountId , @RequestBody AccountDTO request){
        final Account account = accountService.mapToEntity(request);
        Account result = accountService.deposit(accountId, account);
        return accountService.mapToDto(result);
    }


}
