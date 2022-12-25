import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import java.util.List;


public class foo {
    public static void main(String[] args) {
//        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> list = userDao.getAll();
//
//        for (int i=0;i< list.size();i++){
//            System.out.println(list.get(i));
//        }

        UserDaoInter userDao2=Context.instanceUserDao();
        //System.out.println(userDao.getById(6));
//        System.out.println(userDao2.getAll());
    }
}
