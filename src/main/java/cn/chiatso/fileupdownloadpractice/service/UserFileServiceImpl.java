package cn.chiatso.fileupdownloadpractice.service;

import cn.chiatso.fileupdownloadpractice.dao.UserFileDao;
import cn.chiatso.fileupdownloadpractice.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:45
 * @description: TODO
 */
@Service
@Transactional
public class UserFileServiceImpl implements UserFileService {

  @Autowired
  private UserFileDao userFileDao;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<UserFile> findByUserId(String id) {
    return userFileDao.findByUserId(id);
  }
}
