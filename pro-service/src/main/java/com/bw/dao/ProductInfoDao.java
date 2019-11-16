package com.bw.dao;

import com.bw.entity.ProductCategory;
import com.bw.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductInfoDao extends JpaRepository<ProductCategory,Integer>, JpaSpecificationExecutor<ProductCategory> {
}
