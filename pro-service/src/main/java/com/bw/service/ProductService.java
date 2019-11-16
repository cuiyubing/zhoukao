package com.bw.service;

import com.bw.entity.ProductInfo;
import com.bw.entity.ProductVO;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<ProductInfo> selectProductsByCondition(ProductVO productVO);
}
