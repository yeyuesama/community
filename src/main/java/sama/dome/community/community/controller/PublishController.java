package sama.dome.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sama.dome.community.community.model.Poster;
import sama.dome.community.community.model.userinfo;
import sama.dome.community.community.service.Realize.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    //    userinfo user;
//    Poster poster;
    @Autowired
    PostService postService;

    @GetMapping("/publish")
    public String publish() {
//////        System.out.println("1>>>>>>>>>>>>");
//////        List<Poster> poster = postService.selectAll();
//////        QueryWrapper<Poster> qw = new QueryWrapper<>();
//////        qw.select("*");
//////        List<Poster> posters = postService.list(qw);
        return "publish";
    }

    @PostMapping("publish")
//    public String doPublish(
//            @RequestParam("title") String title,
//            @RequestParam("discritpion") String discritpion,
//            @RequestParam("tags") String tags, HttpServletRequest request, Model model) {
    public String doPublish(
//            @RequestParam("title") String title,
//            @RequestParam("discritpion") String discritpion,
//           @RequestParam("tags") String tags,
            Poster poster, HttpServletRequest request, Model model) {
//        System.out.println("2>>>>>>>>>>>");
        model.addAttribute("title", poster.getTitle());
        model.addAttribute("discritpion", poster.getDiscritpion());
        model.addAttribute("tags", poster.getTags());
        userinfo user = (userinfo) request.getSession().getAttribute("user");
//        if (poster.getTitle().equals("") && poster.getDiscritpion().equals("")) {
//            model.addAttribute("poster", poster);
//
//        } else {
//            model.addAttribute("msg", "内容不能为空！");
//        }
        if (user != null) {
            if (poster != null) {
                poster.setCreatorId(user.getUserid());
                poster.setGmtcreat(System.currentTimeMillis());
                poster.setGmtmodifed(poster.getGmtcreat());
                Boolean re = postService.addPost(poster);
                if (re) {
                    return "redirect:/";
                } else {
                    model.addAttribute("msg", "发布失败！");
                    return "publish";
                }
            }else {
                model.addAttribute("msg", "帖子不能为空！");
                return "publish";
            }
        }else {
            model.addAttribute("msg", "未登录！");
            return "publish";
        }

    }
}
