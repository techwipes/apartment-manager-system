package org.techwipes.apartmentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.techwipes.apartmentmanager.model.Account;
import org.techwipes.apartmentmanager.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        Optional<Account> optional = accountRepository.findById(id);
        Account account = null;
        if(optional.isPresent()){
            account = optional.get();
        }else{
            throw new RuntimeException("Account not found for id: " + id);
        }
        return account;

    }

    @Override
    public void deleteAccountById(long id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public Page<Account> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1 ,pageSize);
        return this.accountRepository.findAll(pageable);
    }
}
