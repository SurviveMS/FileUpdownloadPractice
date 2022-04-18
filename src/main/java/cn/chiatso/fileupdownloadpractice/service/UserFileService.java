package cn.chiatso.fileupdownloadpractice.service;

import cn.chiatso.fileupdownloadpractice.entity.UserFile;

import java.util.List;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:44
 * @description: TODO
 */
public interface UserFileService {

  List<UserFile> findByUserId(String id);
}
