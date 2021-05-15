package priv.ljh.uniapp.service.impl;

import priv.ljh.uniapp.entity.TUser;
import priv.ljh.uniapp.mapper.TUserMapper;
import priv.ljh.uniapp.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-15
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
