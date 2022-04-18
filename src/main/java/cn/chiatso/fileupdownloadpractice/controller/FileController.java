package cn.chiatso.fileupdownloadpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:10
 * @description: TODO
 */
@Controller
@RequestMapping("/file")
public class FileController {

  //展示所有文件
  @RequestMapping("/findAll")
  public String findAll() {
    System.out.println("查询所有");
    return "showAll";
  }
}
