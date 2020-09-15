package com.hao.eshopcache.service;

import com.hao.eshopcache.model.ProductInventory;

/**
 * 商品库存Service接口
 */
public interface ProductInventoryService {

    /**
     * 根据商品id查询商品库存
     * @param productId 商品id
     * @return 商品库存
     */
    ProductInventory findProductInventory(Integer productId);

    /**
     * 设置商品库存的缓存
     * @param productInventory 商品库存
     */
    void setProductInventoryCache(ProductInventory productInventory);

    /**
     * 删除Redis中的商品库存的缓存
     * @param productInventory 商品库存
     */
    void removeProductInventoryCache(ProductInventory productInventory);

    /**
     * 更新商品库存
     * @param productInventory 商品库存
     */
    void updateProductInventory(ProductInventory productInventory);
}
