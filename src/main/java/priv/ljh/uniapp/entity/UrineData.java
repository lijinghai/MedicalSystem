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
 * 尿常规数据
 * </p>
 *
 * @author lijinghai
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UrineData对象", description="尿常规数据")
public class UrineData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "与病患资料表关联")
    private Integer patientDataId;

    @ApiModelProperty(value = "尿白细胞")
    private String leu;

    @ApiModelProperty(value = "亚硝酸盐")
    private String nit;

    @ApiModelProperty(value = "尿蛋白")
    private String pro;

    @ApiModelProperty(value = "葡萄糖")
    private String gluU;

    @ApiModelProperty(value = "酮体")
    private String ket;

    @ApiModelProperty(value = "尿胆原")
    private String uro;

    @ApiModelProperty(value = "胆红素")
    private String bil;

    @ApiModelProperty(value = "PH值")
    private String phU;

    @ApiModelProperty(value = "比重")
    private String sg;

    @ApiModelProperty(value = "隐血")
    private String blu;

    @ApiModelProperty(value = "抗坏血酸")
    private String vc;

    @ApiModelProperty(value = "颜色")
    private String col;

    @ApiModelProperty(value = "透明度")
    private String tmd;

    @ApiModelProperty(value = "吞噬细胞")
    private String tsxb;

    @ApiModelProperty(value = "白细胞管型")
    private String uWbcC;

    @ApiModelProperty(value = "颗粒管型")
    private String klgxF;

    @ApiModelProperty(value = "透明管型")
    private String uTmCa;

    @ApiModelProperty(value = "红细胞管型")
    private String uRbc;

    @ApiModelProperty(value = "蜡样管型")
    private String lygx;

    @ApiModelProperty(value = "白细胞镜检 ")
    private String wbcJ1;

    @ApiModelProperty(value = "红细胞镜检")
    private String wbcJ2;

    @ApiModelProperty(value = "备注")
    private String note;


}
