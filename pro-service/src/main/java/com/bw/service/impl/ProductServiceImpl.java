package com.bw.service.impl;

import com.bw.dao.ProductCategoryDao;
import com.bw.dao.ProductInfoDao;
import com.bw.entity.ProductCategory;
import com.bw.entity.ProductInfo;
import com.bw.entity.ProductVO;
import com.bw.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductCategoryDao productCategoryDao;
    @Resource
    private ProductInfoDao productInfoDao;
    @Override
    public Page<ProductInfo> selectProductsByCondition(ProductVO productVO) {
        Specification<ProductInfo> spec = new Specification<ProductInfo>() {
            @Override
            public Predicate toPredicate(Root<ProductInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<>();
                //根据类型查询
                if(productVO.getProductType()!=null){
                    Predicate p = cb.equal(root.get("categoryType"), productVO.getProductType());
                    list.add(p);
                }
                //根据商品名模糊查询
                if(productVO.getProductName()!=null&&!productVO.getProductName().equals("")){
                    Predicate p1 = cb.like(root.get("productName"), "%"+productVO.getProductName()+"%");
                    list.add(p1);
                }
                if(productVO.getPropName()!=null){
                    //根据最小时间查询
                    if(productVO.getStartDate()!=null){
                        Predicate p2 = cb.greaterThan(root.get(productVO.getPropName()), productVO.getStartDate());
                        list.add(p2);
                    }
                    //根据最大时间查询
                    if(productVO.getPropName()!=null&&productVO.getEndDate()!=null){
                        Predicate p3 = cb.lessThan(root.get(productVO.getPropName()), productVO.getEndDate());
                        list.add(p3);
                    }
                }

                //根据最低价格查询
                if(productVO.getMinPrice()!=null){
                    Predicate p4 = cb.ge(root.get("productPrice"), productVO.getMinPrice());
                    list.add(p4);
                }
                //根据最高价格查询
                if(productVO.getMaxPrice()!=null){
                    Predicate p5 = cb.le(root.get("productPrice"), productVO.getMaxPrice());
                    list.add(p5);
                }

                Predicate[] arr = list.toArray(new Predicate[list.size()]);
                return cb.and(arr);
            }
        };

        return productCategoryDao.findAll(spec, PageRequest.of(productVO.getPageNum()-1,productVO.getPageSize()));
    }

    @Override
    public List<ProductCategory> selectProductCategoryList() {
        return productInfoDao.findAll();
    }

    @Override
    public int del(String[] productIds) {
        return productCategoryDao.deleteAllByProductId(productIds);
    }

    @Override
    public int add(ProductInfo productInfo) {
        ProductInfo save = productCategoryDao.save(productInfo);
        if(save!=null){
            return 1;
        }
        return 1;
    }

}
