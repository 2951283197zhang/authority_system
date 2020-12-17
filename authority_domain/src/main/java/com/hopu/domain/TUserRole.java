package com.hopu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_user_role")
@Data
public class TUserRole implements Serializable {
  private static final long serialVersionUID = 1L;

  private String userId;
  private String roleId;
}
