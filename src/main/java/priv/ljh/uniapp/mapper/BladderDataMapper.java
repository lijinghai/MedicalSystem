package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.BladderData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    @Update("update patient_data ,bladder_data set patient_data.bladder_id = #{id} where patient_data.id = #{patient_data_id};")
    int updateBladder(@Param("id") Integer id1,@Param("patient_data_id") Integer id2);
}
