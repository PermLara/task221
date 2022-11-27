package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

//    @Transactional(readOnly = true)
//       public Optional<User> findUserByModelAndSeries(String model, int series) {
//      Optional<User> oneUser = userDao
//              .listUsers()
//              .stream()
//              .filter(e -> e.getHasACar().getModel() == model && e.getHasACar().getSeries() == series)
//              .findFirst();
//      return oneUser;
//   }

//    @Transactional(readOnly = true)
//    public User findUserByModelAndSeries(String model, int series) {
//        User oneUser = null;
//        List<User> listUsers = userDao.listUsers();
//        for (User u: listUsers) {
//            if (u.getHasACar().getModel().equals(model) && u.getHasACar().getSeries() == series) {
//                oneUser = u;
//                break;
//            }
//        }
//        return oneUser;
//    }

    @Transactional(readOnly = true)
    public User findUserByModelAndSeries(String model, int series) {
        return userDao.findUserByModelAndSeries(model, series);
    }

}
