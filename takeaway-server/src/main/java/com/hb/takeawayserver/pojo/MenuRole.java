package com.hb.takeawayserver.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("menu_role")
@ApiModel(value="MenuRole对象", description="")
public class MenuRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "menu 中id")
    private Integer mid;

    @ApiModelProperty(value = "角色id")
    private Integer rid;


}
