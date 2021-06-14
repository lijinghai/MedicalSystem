package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.RenalData;
import priv.ljh.uniapp.entity.UreteralData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 输尿管B超数据资料 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Mapper
@Repository
@ApiModel("输尿管B超数据资料信息实体接口类")
public interface UreteralDataMapper extends BaseMapper<UreteralData> {

    /**
     * 自定义添加语句
     * @param
     * @return
     */
    @Insert(" insert into ureteral_data (patient_data_id) select id  from patient_data where user_id = #{id}")
    int insertUreteral(@Param("id") Integer id);

    /**
     * 自定义更新语句
     * @param id1
     * @param id2
     * @return
     */
    @Update("update patient_data ,ureteral_data set patient_data.ureteral_id = #{id} where patient_data.id = (select patient_data_id  from ureteral_data where ureteral_data.id = #{id});")
    int updateUreteral(@Param("id") Integer id1, @Param("id") Integer id2);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, patient_data_id, param1, param2, param3, param4, param5, note from ureteral_data where id = #{id}")
    List<Map> infoUreteral(@Param("id") Integer id);

    /**
     * 查询所有
     * @param id
     * @return
     */
    @Select("select id, patient_data_id, param1, param2, param3, param4, param5, note from ureteral_data where patient_data_id = (select id from patient_data where user_id = #{id})")
    List<UreteralData> selectAll(@Param("id") Integer id);
}
