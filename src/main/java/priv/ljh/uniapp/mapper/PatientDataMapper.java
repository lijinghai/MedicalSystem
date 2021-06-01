package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.PatientData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 病患资料表 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-01
 */
@Mapper
@Repository
@ApiModel("病患资料表信息实体接口类")
public interface PatientDataMapper extends BaseMapper<PatientData> {

    @Insert("insert into patient_data (user_id) values (#{userId}); ")
    int InsertPatient(@Param("userId")Integer userId);

    @Update("")
    int updatePatient(PatientData patientData);
}
