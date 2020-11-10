package org.techwipes.apartmentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.techwipes.apartmentmanager.model.Account;
import org.techwipes.apartmentmanager.service.AccountServiceImpl;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;


    //display list of accounts
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "apartmentNumber", "asc", model);

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

    // /page/1?sortField=name@sortDir=asc

    // another using without hard fix of page size @GetMapping("/page/{pageNo}/{pageSize}")
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Account> page = accountService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Account> listAccounts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAccounts", listAccounts);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "index";


    }
}
