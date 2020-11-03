package org.techwipes.apartmentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
