package id.co.indivara.jdt12.banklatihan.miniproject.repo;

import id.co.indivara.jdt12.banklatihan.miniproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
