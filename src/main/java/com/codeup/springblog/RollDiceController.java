package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice/{number}")
    public String guessNumber(@PathVariable int number){
        int userGuess = number;
        Random result = new Random();
        int value = result.nextInt(6)+1;

        if(userGuess == value){
            return "Your number "+ userGuess + " matches the random number: "+ value;
        }else {
            return "Your number "+ userGuess + " didn't match the random number: "+value;
        }
    }

}
