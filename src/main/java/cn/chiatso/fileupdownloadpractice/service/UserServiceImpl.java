package cn.chiatso.fileupdownloadpractice.service;

import cn.chiatso.fileupdownloadpractice.dao.UserDao;
import cn.chiatso.fileupdownloadpractice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: chiatso
 * @create: 2022-04-18 11:04
 * @description: TODO
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public User login(User user) {
    return userDao.login(user);
  }
}
