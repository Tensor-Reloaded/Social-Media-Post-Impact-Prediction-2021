package uaic.info.account_management_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uaic.info.account_management_service.entities.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByTwitterId(Long twitterId);
}