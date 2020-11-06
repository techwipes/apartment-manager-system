package org.techwipes.apartmentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.techwipes.apartmentmanager.model.Account;
import org.techwipes.apartmentmanager.service.AccountServiceImpl;

@Controller
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;


    //display list of accounts
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAccounts", accountService.getAllAccounts());
        return "index";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model) {
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        //save account to db
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get account from the service
        Account account = accountService.getAccountById(id);

        //set account object to the model
        model.addAttribute("account", account);
        return "update_account";

    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") long id) {
        //call delete account method
        this.accountService.deleteAccountById(id);
        return ("redirect:/");
    }


}
