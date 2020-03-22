package ua.lviv.lgs.jpa.service;

import ua.lviv.lgs.jpa.entity.Bucket;
import ua.lviv.lgs.jpa.entity.Product;

import java.util.List;

public interface BucketService extends CrudService<Bucket> {
    List<Product> findProductsByUserId(int id);
    void deleteByUserIdAndProductId(int userId, int productId);
}
