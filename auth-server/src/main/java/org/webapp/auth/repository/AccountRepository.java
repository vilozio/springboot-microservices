package org.webapp.auth.repository;

import org.springframework.data.repository.Repository;
import org.webapp.auth.entity.Account;

import java.util.Optional;

public interface AccountRepository extends Repository<Account, Long> {
    Optional<Account> findByUsername(String username);

    Account save(Account account);

}
