package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.persist.ShopProgram;
import com.example.demo.persist.ShopRepository;

    @Controller
    public class ShopControllers {

        private ShopRepository repository;

        @Autowired
        public ShopControllers(ShopRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public String indexPage(Model model) {
            model.addAttribute("items", repository.findAll());
            model.addAttribute("item", new ShopProgram());
            return "index";
        }

        @PostMapping
        public String newShopProgram(ShopProgram shopProgram) {
            repository.save(shopProgram);
            return "redirect:/";
        }

        @DeleteMapping("/{id}")
        public String deleteShopProgram(@PathVariable("id") Long id) {
            repository.deleteById(id);
            return "redirect:/";
        }
    }
