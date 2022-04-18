package cn.chiatso.fileupdownloadpractice.service;

import cn.chiatso.fileupdownloadpractice.dao.UserFileDao;
import cn.chiatso.fileupdownloadpractice.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

  @Override
  public void save(UserFile userFile) {
    //判断是否是图片，判断类型是否包含image/xxx
    if(userFile.getType().contains("image")){
      userFile.setIsImg("是");
    }else{
      userFile.setIsImg("否");
    }
    userFile.setUploadTime(new Date());
    userFile.setDownloadCount(0);
    userFileDao.save(userFile);
  }

  @Override
  public UserFile findById(String id) {
    return userFileDao.findById(id);
  }

  @Override
  public void update(UserFile userFile) {
    userFileDao.update(userFile);
  }
}
