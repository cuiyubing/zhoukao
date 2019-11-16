package com.bw.service;

import com.bw.entity.ProductCategory;
import com.bw.entity.ProductInfo;
import com.bw.entity.ProductVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductInfo> selectProductsByCondition(ProductVO productVO);
    List<ProductCategory> selectProductCategoryList();
}
