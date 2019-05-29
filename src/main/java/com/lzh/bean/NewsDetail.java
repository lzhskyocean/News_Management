package com.lzh.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDetail {

  private long id;
  private String title;
  private String summary;
  private String author;
  private Date createDate;


}
