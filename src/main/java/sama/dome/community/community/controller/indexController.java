package sama.dome.community.community.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sama.dome.community.community.dto.PosterDTO;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.Poster_userService;
import sama.dome.community.community.service.Realize.UserService;

import java.util.List;

//页面分发处理
@Controller
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    Poster_userService poster_userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
     public String Index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<PosterDTO> posterDTOS = poster_userService.Post_user();
        PageInfo<PosterDTO> posterDTOPageInfo = new PageInfo<PosterDTO>(posterDTOS);
        model.addAttribute("allinfo",posterDTOPageInfo);
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
