package com.hopu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_menu")
@Data
public class TMenu extends BaseEntity{
  private static final long serialVersionUID = 1L;

  private String pid;
  private String menuName;
  private long menuType;
  private String menuImg;
  private String permiss;
  private String url;
  private String functionImg;
  private String seq;

  @TableField(exist=false)
  private List<TMenu> nodes;
}
