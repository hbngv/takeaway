package com.hb.takeawayserver.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hb
 * @since 2022-10-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Event对象", description="")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "区域 如青教、兰苑等")
    private String area;

    @ApiModelProperty(value = "详细描述")
    private String detail;

    @ApiModelProperty(value = "具体位置照片")
    private String photo;

    @ApiModelProperty(value = "起始时间")
    private LocalDateTime start;

    @ApiModelProperty(value = "终止时间")
    private LocalDateTime end;

    @ApiModelProperty(value = "外卖店铺名称")
    private String shopName;


}
