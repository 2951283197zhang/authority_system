package com.hopu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_user")
@Data
public class TUser extends BaseEntity{
  private static final long serialVersionUID = 1L;
  //private String id;
  private String userName;
  private String password;
  private String salt;
  private String nickname;
  private String userImg;
  private String tel;
  private String sex;
  private String email;
  private String status;
 /* private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;*/

  @Override
  public String toString() {
    return "TUser{" +
            "userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", nickname='" + nickname + '\'' +
            ", userImg='" + userImg + '\'' +
            ", tel='" + tel + '\'' +
            ", sex=" + sex +
            ", email='" + email + '\'' +
            ", status='" + status + '\'' +
            '}';
  }
}
