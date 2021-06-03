package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.RenalData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 肾功能资料 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Mapper
@Repository
@ApiModel("肾功能资料信息实体接口类")
public interface RenalDataMapper extends BaseMapper<RenalData> {
    /**
     * 自定义添加语句
     * @param
     * @return
     */
    @Insert(" insert into renal_data (patient_data_id) select id  from patient_data")
    int insertRenal();

    /**
     * 自定义更新语句
     * @param id1
     * @param id2
     * @return
     */
    @Update("update patient_data ,renal_data set patient_data.renal_id = #{id} where patient_data.id = (select patient_data_id  from renal_data where renal_data.id = #{id});")
    int updateRenal(@Param("id") Integer id1, @Param("id") Integer id2);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, patient_data_id, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, note from renal_data where id = #{id}")
    List<Map> infoRenal(@Param("id") Integer id);
}
