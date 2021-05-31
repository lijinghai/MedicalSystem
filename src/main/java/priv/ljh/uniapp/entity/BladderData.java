package priv.ljh.uniapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 膀胱动力学资料
 * </p>
 *
 * @author lijinghai
 * @since 2021-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BladderData对象", description="膀胱动力学资料")
public class BladderData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "病人数据表关联")
    private Integer patientDataId;

    @ApiModelProperty(value = "最大膀胱测压容量(ml)")
    private Double bladderCapacity;

    @ApiModelProperty(value = "排尿期最大逼尿肌压(cmH2O)")
    private Double bladderDetrusorPressure;

    @ApiModelProperty(value = "膀胱顺应性(ml/cmH2O)")
    private Double bladderCompliance;

    @ApiModelProperty(value = "记录")
    private String note;


}
