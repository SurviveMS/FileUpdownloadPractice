package cn.chiatso.fileupdownloadpractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.chiatso.fileupdownloadpractice.dao")
@SpringBootApplication
public class FileUpDownloadPracticeApplication {

  public static void main(String[] args) {
    SpringApplication.run(FileUpDownloadPracticeApplication.class, args);
  }

}
