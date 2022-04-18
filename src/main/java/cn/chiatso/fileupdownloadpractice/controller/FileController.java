package cn.chiatso.fileupdownloadpractice.controller;

import cn.chiatso.fileupdownloadpractice.entity.User;
import cn.chiatso.fileupdownloadpractice.entity.UserFile;
import cn.chiatso.fileupdownloadpractice.service.UserFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.io.File;

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
    User user = (User) session.getAttribute("user");
    List<UserFile> files = userFileService.findByUserId(user.getId());
    model.addAttribute("files", files);
    return "showAll";
  }

  //上传文件，所有文件以files为顶级目录
  @RequestMapping("/upload")
  public String upload(MultipartFile file, HttpSession session) throws Exception{
    //用户
    User user = (User)session.getAttribute("user");

    //原始名称
    String originalFilename = file.getOriginalFilename();

    //获取原始文件后缀
    String extension = "." + FilenameUtils.getExtension(originalFilename);

    //生成新的文件名称
    String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
            UUID.randomUUID().toString().replaceAll("-", "")
            + extension;

    //文件的大小
    long size = file.getSize();

    //文件类型
    String type = file.getContentType();

    //处理根据日期生成目录
    String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/files";
    String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String dateDirPath = realPath + "/" +dateFormat;
    File dateDir = new File(dateDirPath);
    if(!dateDir.exists()) {
      //文件夹不存在创建
      dateDir.mkdirs();
    }

    //处理文件上传
    file.transferTo(new File(dateDir, newFileName));

    //将文件信息存入数据库
    UserFile userFile = new UserFile();
    userFile.setOldFileName(originalFilename).setNewFileName(newFileName).setExt(extension)
                    .setSize(size).setType(type).setPath("/files/" + dateFormat).setUserId(user.getId());
    userFileService.save(userFile);
    return "redirect:/file/findAll";
  }


  //文件下载
  @RequestMapping("/download")
  public void download(String openStyle, String id, HttpServletResponse response) throws Exception{
    UserFile userFile = userFileService.findById(id);
    //获取打开方式
    openStyle = openStyle==null ? "attachment" : "inline";
    //根据文件信息的文件名字和存储路径获取输入流
    String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static" + userFile.getPath();
    //更新下载次数
    if(openStyle.equalsIgnoreCase("attachment")) {
      userFile.setDownloadCount(userFile.getDownloadCount() + 1);
    }
    userFileService.update(userFile);
    //获取文件输入流
    FileInputStream in = new FileInputStream(new File(realPath, userFile.getNewFileName()));
    //附件下载
    response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(userFile.getOldFileName(), "UTF-8"));
    //获取响应输出流
    ServletOutputStream out = response.getOutputStream();
    //拷贝
    IOUtils.copy(in, out);
    //关闭
    IOUtils.closeQuietly(in);
    IOUtils.closeQuietly(out);
  }
}
