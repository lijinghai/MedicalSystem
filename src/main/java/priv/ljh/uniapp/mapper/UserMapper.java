package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-28
 */
@Mapper
@Repository
@ApiModel("用户信息接口类")
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where account = #{account} and password= #{password}")
    User login(User user);
}
