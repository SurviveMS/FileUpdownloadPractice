package cn.chiatso.fileupdownloadpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:23
 * @description: TODO
 */
@Controller
public class IndexController {

  @RequestMapping("/showAll")
  public String toIndex() {
    return "showAll";
  }
}
