package com.bw.controller;

import com.bw.entity.ProductCategory;
import com.bw.entity.ProductInfo;
import com.bw.entity.ProductVO;
import com.bw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("list")
    public Page<ProductInfo> selectProductsByCondition(ProductVO productVO){
        System.out.println(productVO);
//        ProductVO p = new ProductVO();
//        p.setPageNum(1);
//        p.setPageSize(3);
        Page<ProductInfo> productInfos = productService.selectProductsByCondition(productVO);
        System.out.println(productInfos);
        return productService.selectProductsByCondition(productVO);
    }
    @RequestMapping("gettypelist")
    public List<ProductCategory> gettypelist(){
        return productService.selectProductCategoryList();
    }
}
