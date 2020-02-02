package sama.dome.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.UserService;

import java.util.function.BinaryOperator;

@Controller
public class RegisteredController {
    @Autowired
    UserService userService;

    @GetMapping("/registered")
    public String doRegistered() {

        return "registered";
    }

    @PostMapping("/registered")
    public String Relogin(
            Model model,
            userinfo reuser,
            @RequestParam("repassword") String repassword
    ) {
        model.addAttribute("rename",reuser.getUsername());
        model.addAttribute("renickname",reuser.getNickname());
        userinfo user = userService.getuserByaccount(reuser.getUsername());
        if (user != null) {
            model.addAttribute("remsg","账户已被使用！");
            return "registered";
        } else {
            if (reuser.getPassword().equals(repassword)) {
                reuser.setAvatarurl("https://bkimg.cdn.bcebos.com/pic/fcfaaf51f3deb48ff27285c8f31f3a292df57888?x-bce-process=image/watermark,g_7,image_d2F0ZXIvYmFpa2UyNzI=,xp_5,yp_5");
                Boolean re = userService.adduser(reuser);
                if (re) {
                    return "login";
                } else {
                    model.addAttribute("remsg", "注册失败请重试");
                    return "registered";
                }
            } else {
                model.addAttribute("remsg","两次密码不一致");
                return "error";
            }
        }

    }
}
