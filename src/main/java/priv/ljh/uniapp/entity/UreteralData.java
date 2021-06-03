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
 * 输尿管B超数据资料
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UreteralData对象", description="输尿管B超数据资料")
public class UreteralData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "病患资料表关联")
    private Integer patientDataId;

    @ApiModelProperty(value = "输尿管结石")
    private String param1;

    @ApiModelProperty(value = "输尿管外伤")
    private String param2;

    @ApiModelProperty(value = "输尿管肿瘤")
    private String param3;

    @ApiModelProperty(value = "泌尿系先天性发育异常")
    private String param4;

    @ApiModelProperty(value = "先天性巨输尿管")
    private String param5;

    @ApiModelProperty(value = "备注")
    private String note;


}
