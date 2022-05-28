package com.cdp.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cdp.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("user")
@EqualsAndHashCode(callSuper=false)
public class User extends BaseModel {
}
