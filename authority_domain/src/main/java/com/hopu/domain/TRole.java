package com.hopu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_role")
@Data
public class TRole extends BaseEntity{
 private static final long serialVersionUID = 1L;
 // private String id;
  private String role;
  private String remark;
 /* private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;*/

}
