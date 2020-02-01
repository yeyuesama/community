package sama.dome.community.community.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("login123")
    @ResponseBody
    public String lgi(@RequestParam(name = "account") String name,
                      @RequestParam(name = "password") String passwd){
        return "123";
    }

    //验证登录
    @PostMapping("login")
    public String Index(@RequestParam(name = "account") String name,
                        @RequestParam(name = "password") String passwd,
                        HttpServletResponse response,
                        Model model,
                        userinfo user, HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView();
        String rembMe = request.getParameter("rememberMe");
        userinfo usinfo = userService.getuser(name, passwd);
        model.addAttribute("userInfo", name);
        if (usinfo != null) {
            user.setUserid(usinfo.getUserid());
            user.setUsername(usinfo.getUsername());
            user.setPassword(usinfo.getPassword());
            user.setNickname(usinfo.getNickname());
            request.getSession().setAttribute("user", user);
//            mav.setViewName("index");
            return "redirect:/";
        } else {
//            mav.setViewName("error");
            return "login";
        }
    }

}
