package priv.ljh.uniapp.mapper;

import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;
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

}
