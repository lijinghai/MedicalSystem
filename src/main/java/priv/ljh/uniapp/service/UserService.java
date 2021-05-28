package priv.ljh.uniapp.service;

import priv.ljh.uniapp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import priv.ljh.utils.MyPage;

import java.util.List;

/**
 * <p>
 *  用户信息 服务类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-28
 */
public interface UserService extends IService<User> {
    User login(User pcUser);

    /**
     * 自定义分页查询方法
     * @param pageNo
     * @param limit
     * @param idSorted
     * @param Users
     * @return
     */
    public MyPage searchUser(int pageNo, int limit, String idSorted, List<User> Users);
}
