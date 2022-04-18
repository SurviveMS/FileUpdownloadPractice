package cn.chiatso.fileupdownloadpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:34
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserFile {

  private Integer id;
  private String oldFileName;
  private String newFileName;
  private String ext;
  private String path;
  private Long size;
  private String type;
  private String isImg;
  private Integer downloadCount;
  private Date uploadTime;
  private String userId;
}
