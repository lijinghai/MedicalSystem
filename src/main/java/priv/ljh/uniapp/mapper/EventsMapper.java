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
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, user_id, event_time, event_type, water_code, total_capacity, urgent_level, is_incontinence, incontinence_type, is_pain, is_leak, is_difficult, note from events where id = #{id}")
    List<Map> infoEvents(@Param("id") Integer id);

    /**
     * 自定义添加餐饮事件
     * @param userId
     * @return
     */
    @Insert("insert into events (user_id,note) values (#{userId},'餐饮事件');")
    int insertFood(@Param("userId")Integer userId);

    /**
     * 查询餐饮事件
     * @return
     */
    @Select("select *  from events where  user_id= #{id} and note ='餐饮事件'")
    List<Map> infoFirst(@Param("id") Integer id);

    /**
     * 自定义添加导尿事件
     * @param userId
     * @return
     */
    @Insert("insert into events (user_id,note) values (#{userId},'导尿事件');")
    int insertSecond(@Param("userId")Integer userId);

    /**
     * 查询导尿事件
     * @return
     */
    @Select("select * from events where user_id = #{id} and note ='导尿事件';")
    List<Map> infoSecond(@Param("id") Integer id);

    /**
     * 自定义添加导尿事件
     * @param userId
     * @return
     */
    @Insert("insert into events (user_id,note) values (#{userId},'特殊事件');")
    int insertThird(@Param("userId")Integer userId);

    /**
     * 查询特殊事件
     * @return
     */
    @Select("select *  from events where  user_id = #{id} and note ='特殊事件';")
    List<Map> infoThird(@Param("id") Integer id);

}
