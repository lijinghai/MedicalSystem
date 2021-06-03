package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.Events;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, user_id, event_time, event_type, water_code, total_capacity, urgent_level, is_incontinence, incontinence_type, is_pain, is_leak, is_difficult, note from events where id = #{id}")
    List<Map> infoEvents(@Param("id") Integer id);
}
