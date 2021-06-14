package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import priv.ljh.uniapp.entity.BladderData;
import priv.ljh.uniapp.entity.UrineData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 尿常规数据 Mapper 接口
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Mapper
@Repository
@ApiModel("尿常规数据信息实体接口类")
public interface UrineDataMapper extends BaseMapper<UrineData> {
    /**
     * 自定义添加语句
     * @param
     * @return
     */
    @Insert("insert into urine_data (patient_data_id) select id  from patient_data where user_id = #{id}")
    int insertUrine(@Param("id") Integer id);

    /**
     * 自定义更新语句
     * @param id1
     * @param id2
     * @return
     */
    @Update("update patient_data ,urine_data set patient_data.urine_id = #{id} where patient_data.id = (select patient_data_id  from urine_data where urine_data.id = #{id});")
    int updateUrine(@Param("id") Integer id1, @Param("id") Integer id2);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select id, patient_data_id, leu, nit, pro, glu_u, ket, uro, bil, ph_u, sg, blu, vc, col, tmd, tsxb, u_wbc_c, klgx_f, u_tm_ca, u_rbc, lygx, wbc_j1, wbc_j2, note from urine_data where id = #{id}")
    List<Map> infoUrine(@Param("id") Integer id);


    /**
     * 查询所有
     * @param id
     * @return
     */
    @Select("select id, patient_data_id, leu, nit, pro, glu_u, ket, uro, bil, ph_u, sg, blu, vc, col, tmd, tsxb, u_wbc_c, klgx_f, u_tm_ca, u_rbc, lygx, wbc_j1, wbc_j2, note from urine_data where patient_data_id = (select id from patient_data where user_id = #{id})")
    List<UrineData> selectAll(@Param("id") Integer id);
}
