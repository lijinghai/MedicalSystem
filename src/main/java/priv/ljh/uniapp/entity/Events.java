package priv.ljh.uniapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 事件表
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Events对象", description="事件表")
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户表关联")
    private Integer userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "默认当前时间")
    private Date eventTime;

    @ApiModelProperty(value = "饮食：1，导尿：2；漏尿：3")
    private Integer eventType;

    @ApiModelProperty(value = "餐饮种类 水,咖啡,苏打水,啤酒,果汁")
    private String waterCode;

    @ApiModelProperty(value = "总容量 ")
    private Double totalCapacity;

    @ApiModelProperty(value = "尿急迫程度 1，2，3，4")
    private Integer urgentLevel;

    @ApiModelProperty(value = "导尿前后是否尿失禁 是：1；否：0")
    private Integer isIncontinence;

    @ApiModelProperty(value = "尿失禁类别 压力性 1/急迫性 2/充溢性 3/混合性 4")
    private Integer incontinenceType;

    @ApiModelProperty(value = "排尿前尿急迫或疼痛 是：1；否：0")
    private Integer isPain;

    @ApiModelProperty(value = "是否漏尿 是：1；否：0")
    private Integer isLeak;

    @ApiModelProperty(value = "是否插管困难 是：1；否：0")
    private Integer isDifficult;

    @ApiModelProperty(value = "备注")
    private String note;


}
