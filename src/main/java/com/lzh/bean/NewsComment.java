package com.lzh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsComment {

  private Date createDate;

  @NotBlank(message = "作者不能为空")
  private String author;
  @NotBlank(message = "内容不能为空")
  private String content;
  private Long newsId;
  private Long id;


}
