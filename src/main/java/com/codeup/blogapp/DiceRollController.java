package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@Controller
public class DiceRollController {
    private final Random random = new Random();

    @GetMapping("/roll-dice")
    public String showRollDice(){
        return "roll-dice";
    }
    @PostMapping("/roll-dice")
    public String rollDice(@RequestParam(name = "guess") String guess, Model model) {
        model.addAttribute("guess", "You guessed " + guess + "!");
        return "roll-dice";
    }
}
