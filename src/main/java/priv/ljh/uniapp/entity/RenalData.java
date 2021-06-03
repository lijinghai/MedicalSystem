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
 * 肾功能资料
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RenalData对象", description="肾功能资料")
public class RenalData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "病患资料表关联")
    private Integer patientDataId;

    @ApiModelProperty(value = "尿素")
    private String param1;

    @ApiModelProperty(value = "肌酐")
    private String param2;

    @ApiModelProperty(value = "葡萄糖")
    private String param3;

    @ApiModelProperty(value = "钾")
    private String param4;

    @ApiModelProperty(value = "钠")
    private String param5;

    @ApiModelProperty(value = "氯")
    private String param6;

    @ApiModelProperty(value = "钙")
    private String param7;

    @ApiModelProperty(value = "二氧化碳")
    private String param8;

    @ApiModelProperty(value = "尿酸")
    private String param9;

    @ApiModelProperty(value = "磷")
    private String param10;

    @ApiModelProperty(value = "镁")
    private String param11;

    @ApiModelProperty(value = "淀粉酶")
    private String param12;

    @ApiModelProperty(value = "脂肪酶测定")
    private String param13;

    @ApiModelProperty(value = "备注")
    private String note;


}
