package cn.chiatso.fileupdownloadpractice.controller;

import cn.chiatso.fileupdownloadpractice.entity.User;
import cn.chiatso.fileupdownloadpractice.entity.UserFile;
import cn.chiatso.fileupdownloadpractice.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:10
 * @description: TODO
 */
@Controller
@RequestMapping("/file")
public class FileController {

  @Autowired
  private UserFileService userFileService;

  //展示所有文件
  @RequestMapping("/findAll")
  public String findAll(HttpSession session, Model model) {
    User user = (User)session.getAttribute("user");
    List<UserFile> files = userFileService.findByUserId(user.getId());
    model.addAttribute("files", files);
    return "showAll";
  }

}
