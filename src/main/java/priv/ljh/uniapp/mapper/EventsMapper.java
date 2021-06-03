package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.Events;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 事件表 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Mapper
@Repository
@ApiModel("事件表实体接口类")
public interface EventsMapper extends BaseMapper<Events> {
    /**
     * 自定义添加
     * @param userId
     * @return
     */
    @Insert("insert into events (user_id) values (#{userId});")
    int insertEvents(@Param("userId")Integer userId);
}
