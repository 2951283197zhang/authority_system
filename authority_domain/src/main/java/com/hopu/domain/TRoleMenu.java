package com.hopu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_role_menu")
@Data
public class TRoleMenu implements Serializable {
  private static final long serialVersionUID = 1L;

  private String menuId;
  private String roleId;
}
