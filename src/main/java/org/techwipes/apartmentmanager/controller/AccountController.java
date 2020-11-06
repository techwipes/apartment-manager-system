package org.techwipes.apartmentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.techwipes.apartmentmanager.model.Account;
import org.techwipes.apartmentmanager.service.AccountServiceImpl;

@Controller
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;


    //display list of accounts
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "index";
    }
    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model){
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "new account";
    }
}
