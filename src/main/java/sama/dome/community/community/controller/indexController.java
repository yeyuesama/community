package sama.dome.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/getall")
    public String testSelect(Model model){
        List<userinfo> getall = userService.getalluser();
        model.addAttribute("all",getall);
        return "index";
    }
    @RequestMapping(value = "login.action")
    public ModelAndView Index(userinfo user, HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        String name = request.getParameter("account");
        String passwd = request.getParameter("password");
        userinfo usinfo = userService.getuser(name,passwd);
        if(usinfo != null){
            user.setUserid(usinfo.getUserid());
            user.setUsername(usinfo.getUsername());
            user.setPassword(usinfo.getPassword());
            user.setNickname(usinfo.getNickname());
            session.setAttribute("user",user);
            mav.setViewName("index");
            return mav;
        }else{
            mav.setViewName("error");
        }
        return mav;
    }
}
