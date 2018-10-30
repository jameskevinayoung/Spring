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
    @ResponseBody //use response body to render a literal string of information in the controller
    public String showDice(){
        /**
         * Send user to pick a number between 1 and 6 on the roll-dice page that has links.
         */

        return "Pick a number. <br/><ul>" +
                    "<li><a href='/roll-dice/1'>1</a></li>"+
                    "<li><a href='/roll-dice/2'>2</a></li>"+
                    "<li><a href='/roll-dice/3'>3</a></li>"+
                    "<li><a href='/roll-dice/4'>4</a></li>"+
                    "<li><a href='/roll-dice/5'>5</a></li>"+
                    "<li><a href='/roll-dice/6'>6</a></li>"+
                "</ul>";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String guessNumber(@PathVariable int n){
/**
 * 1) Use a method to randomly generate an integer that has a maximum number of 6.
 * 2) Set the maximum and minimum parameters the user can guess from. this will be used as the range of the random number.
 * 3) Create a path to pass the variable number that is received from the user picking a link on /roll-dice
 */
        int result = new Random().nextInt(6)+1;

        if(n == result){
            return "Your number "+ n + " matches the random number: "+ result;
        }else {
            return "Your number "+ n + " didn't match the random number: "+result;
        }
//        viewNumber.addAttribute("number",n);
//        viewNumber.addAttribute("result", result);

    }



}
