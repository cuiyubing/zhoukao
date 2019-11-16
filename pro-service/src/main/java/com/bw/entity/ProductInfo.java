package com.bw.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Table(name = "product_info")
@Entity
public class ProductInfo implements Serializable {

    @Id
    @GeneratedValue
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus = 0;

    /** 类目编号. */
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_type",referencedColumnName = "category_type")
    private Integer categoryType;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    /*public static void main(String[] args) {
        // add subtract
        BigDecimal a = new BigDecimal(5);
        BigDecimal b = new BigDecimal("1.2");
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b,2,BigDecimal.ROUND_HALF_UP));

    }*/
}
