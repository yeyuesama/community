package sama.dome.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sama.dome.community.community.model.Poster;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.UserService;

import java.util.List;

//页面分发处理
@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
     public String Index(){
        return "index";
     }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/getall")
    public String testSelect(Model model){
        List<userinfo> getall = userService.getalluser();
        model.addAttribute("all",getall);
        return "index";
    }
}
