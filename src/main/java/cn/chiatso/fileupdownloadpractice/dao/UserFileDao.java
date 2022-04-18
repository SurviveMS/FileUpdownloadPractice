package cn.chiatso.fileupdownloadpractice.dao;

import cn.chiatso.fileupdownloadpractice.entity.UserFile;

import java.util.List;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:38
 * @description: TODO
 */
public interface UserFileDao {

  //根据用户id获取用户文件列表
  List<UserFile> findByUserId(String id);
}
