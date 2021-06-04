package com.fatec.farmacia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/app")
    public String main(Model model) {

        model.addAttribute("teste", "Daniel");

        return "app";
    }

}