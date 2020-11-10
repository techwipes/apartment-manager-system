package org.techwipes.apartmentmanager.service;

import org.springframework.data.domain.Page;
import org.techwipes.apartmentmanager.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account getAccountById(long id);

    void deleteAccountById(long id);

    Page<Account> findPaginated(int pageNo, int pageSize);
}
