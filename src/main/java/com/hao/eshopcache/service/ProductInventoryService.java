package com.hao.eshopcache.service;

import com.hao.eshopcache.dao.RedisDAO;
import com.hao.eshopcache.mapper.ProductInventoryMapper;
import com.hao.eshopcache.model.ProductInventory;
import com.hao.eshopcache.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品库存Service实现类
 */
@Service
public class ProductInventoryService {

    @Autowired
    ProductInventoryMapper mapper;

    @Autowired
    RedisDAO redisDAO;

    /**
     * 根据商品id查询商品库存
     *
     * @param productId 商品id
     * @return 商品库存
     */
    public ProductInventory findProductInventory(Integer productId) {
        return mapper.findProductInventory(productId);
    }

    /**
     * 设置商品库存信息到缓存中
     *
     * @param productInventory
     */
    public void setProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDAO.set(key, String.valueOf(productInventory.getInventoryCnt()));
    }

    /**
     * 移除库存缓存
     *
     * @param productInventory
     */
    public void removeProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDAO.delete(key);
    }

    /**
     * 更新商品库存信息
     *
     * @param productInventory
     */
    public void updateProductInventory(ProductInventory productInventory) {
        mapper.updateProductInventory(productInventory);
    }
}
