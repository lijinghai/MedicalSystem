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
 * 病患资料表
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PatientData对象", description="病患资料表")
public class PatientData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "user表关联")
    private Integer userId;

    @ApiModelProperty(value = "身高")
    private Double height;

    @ApiModelProperty(value = "体重")
    private Double weight;

    @ApiModelProperty(value = "是否怀孕 是：1；否：0")
    private Integer pregnant;

    @ApiModelProperty(value = "膀胱动力学数据编号")
    private Integer bladderId;

    @ApiModelProperty(value = "尿常规数据编号")
    private Integer urineId;

    @ApiModelProperty(value = "肾功能数据编号")
    private Integer renalId;

    @ApiModelProperty(value = "输尿管B超数据编号")
    private Integer ureteralId;

    @ApiModelProperty(value = "医院编号")
    private Integer hospitalId;

    @ApiModelProperty(value = "科室编号")
    private Integer departmentId;


}
