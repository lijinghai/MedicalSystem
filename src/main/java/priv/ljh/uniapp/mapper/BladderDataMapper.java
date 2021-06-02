package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.BladderData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 膀胱动力学资料 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-31
 */
@Mapper
@Repository
@ApiModel("膀胱动力学资料信息实体接口类")
public interface BladderDataMapper extends BaseMapper<BladderData> {

    /**
     * 自定义添加语句
     * @param
     * @return
     */
    @Insert(" insert into bladder_data (patient_data_id) select id  from patient_data")
    int insertBladder();

    /**
     * 自定义更新语句
     * @param id1
     * @param id2
     * @return
     */
    @Update("update patient_data ,bladder_data set patient_data.bladder_id = #{id} where patient_data.id = #{patient_data_id};")
    int updateBladder(@Param("id") Integer id1,@Param("patient_data_id") Integer id2);

    /**
     * 根据id更新语句
     * @param id1
     * @param id2
     * @param id3
     * @return
     */
    @Update("update bladder_data set bladder_capacity =#{bladder_capacity}, bladder_detrusor_pressure = #{bladder_detrusor_pressure},bladder_compliance = #{bladder_compliance} where id = #{id};")
    int updateBladderById(@Param("bladder_capacity") Integer id1,@Param("bladder_detrusor_pressure") Integer id2,@Param("bladder_compliance") Integer id3,@Param("id") Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id,  patient_data_id, bladder_capacity, bladder_detrusor_pressure, bladder_compliance, note from bladder_data where id = #{id}")
    List<Map> infoBladder(@Param("id") Integer id);
}
