package priv.ljh.uniapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.ljh.uniapp.entity.User;
import priv.ljh.uniapp.mapper.UserMapper;
import priv.ljh.uniapp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.ljh.utils.MyPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public User login(User User) {
        //根据接受的用户名和密码查询数据库
        User userDB = UserMapper.login(User);
        if(userDB != null){
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }

    @Override
    public MyPage searchUser(int pageNo, int limit, String idSorted, List<User> Users) {
        MyPage page = null;
        List<User> pcUsersList = new ArrayList<>();
        pcUsersList.addAll(Users);
        if(idSorted != null && idSorted.startsWith("-")){
            Collections.reverse(pcUsersList);
        }
        int total = pcUsersList.size();
        int maxPageNo = pcUsersList.size()%limit == 0? pcUsersList.size()/limit:pcUsersList.size()/limit + 1;
        if(pageNo>maxPageNo){
            pageNo = maxPageNo;
        }
        int beginIndex = (pageNo-1)*limit;
        int endIndex = pageNo*limit;
        if(endIndex>total){
            endIndex = total;
        }

        page = new MyPage(pcUsersList.subList(beginIndex, endIndex), total);

        return page;
    }
}
