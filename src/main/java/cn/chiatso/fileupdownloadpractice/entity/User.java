package cn.chiatso.fileupdownloadpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:00
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
  private String id;
  private String username;
  private String password;
}
