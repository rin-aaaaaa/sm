package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
    private String writer;
    private String title;
    private String content;
    private int viewCnt;
    private Date writerDate;
}
