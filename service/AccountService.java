package id.co.indivara.jdt12.banklatihan.miniproject.service;

import id.co.indivara.jdt12.banklatihan.miniproject.dto.AccountDTO;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Account;
import id.co.indivara.jdt12.banklatihan.miniproject.entity.Costumer;

public interface AccountService {
    Account addAccount(Long costumerId, Account account);

    Account deposit(Long costumerId, Account account);

    Boolean delete(Long id);
    Account findById(Long id);
    Account mapToEntity(AccountDTO accountDTO);
    AccountDTO mapToDto(Account account);
}
