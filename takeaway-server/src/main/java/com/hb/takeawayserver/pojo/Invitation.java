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
@ApiModel(value="Invitation对象", description="")
public class Invitation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "发帖子用户的id")
    private Integer uid;

    @ApiModelProperty(value = "事件具体信息")
    private Integer eid;

    @ApiModelProperty(value = "帖子标题")
    private String title;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
