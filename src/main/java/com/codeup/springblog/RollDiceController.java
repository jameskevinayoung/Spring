package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String pickNumber(){
        return "Pick a number";
    }

    @GetMapping("/roll-dice/{number}")
    public String guessNumber(@PathVariable int number, Model viewNumber){

        Random result = new Random();
        int value = result.nextInt(6)+1;

        viewNumber.addAttribute("number",number);
        viewNumber.addAttribute("value", value);

        if(number == value){
            return "Your number "+ number + " matches the random number: "+ value;
        }else {
            return "Your number "+ number + " didn't match the random number: "+value;
        }
    }

}
