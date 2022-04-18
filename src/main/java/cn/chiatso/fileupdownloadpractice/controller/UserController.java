package cn.chiatso.fileupdownloadpractice.controller;

import cn.chiatso.fileupdownloadpractice.entity.User;
import cn.chiatso.fileupdownloadpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:05
 * @description: TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  //登录
  @PostMapping("/login")
  public String login(User user, HttpSession session) {
    User userDb = userService.login(user);
    if(userDb != null) {
      session.setAttribute("user", userDb);
      return "redirect:/file/findAll";
    }else {
      return "redirect:/login.html";
    }
  }
}
