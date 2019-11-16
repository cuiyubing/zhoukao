package com.bw.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class ProductVO {


    /** 名字. */
    private String productName;

    /** 最低价. */
    private BigDecimal minPrice;

    /** 最高价. */
    private BigDecimal maxPrice;

    /** 商品类型. */
    private Integer productType;

    //属性名
    private String propName;
    //开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    //结束日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    //第几页
    private Integer pageNum;
    //每页条数
    private Integer pageSize;


}
