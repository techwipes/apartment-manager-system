package org.techwipes.apartmentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
