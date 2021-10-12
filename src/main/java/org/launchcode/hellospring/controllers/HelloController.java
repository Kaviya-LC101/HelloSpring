package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello,Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye(){
        return "Goodbye,Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
//
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, "+name+"!";
//    }
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name){
        return "Hello, "+name+"!";
    }

    @GetMapping("form")

    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +//submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'><br>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>"+
                "<option value='Italian'>Italian</option>"+
                "<option value='Spanish'>Spanish</option>"+
                "<option value='German'>German</option>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {



        return createMessage(name, language);


    }
    public static String createMessage(String n, String l) {
        String greeting = "";


        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("French")) {
            greeting = "Bonjour";
        }
        else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("German")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }

}
