package ua.lviv.lgs.jpa.dao;

import ua.lviv.lgs.jpa.entity.Bucket;
import ua.lviv.lgs.jpa.entity.Product;

import java.util.List;

public interface BucketDao extends Dao<Bucket> {
    List<Product> findProductsByUserId(int userId);
    void deleteByUserIdAndProductId(int userId, int productId);
}
