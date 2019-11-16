package com.bw.dao;

import com.bw.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductCategoryDao extends JpaRepository<ProductInfo,String>, JpaSpecificationExecutor<ProductInfo> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "delete from product_info where product_id in (:productIds)")
    int deleteAllByProductId(@Param("productIds") String productIds);
}
