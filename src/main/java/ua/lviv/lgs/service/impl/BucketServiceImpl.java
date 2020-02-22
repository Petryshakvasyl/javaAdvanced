package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.repository.BucketRepository;
import ua.lviv.lgs.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository;

    public BucketServiceImpl() {
        this.bucketRepository = BucketRepositoryImpl.getInstance();
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public Bucket findById(Integer id) {
        return bucketRepository.findById(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketRepository.update(bucket);
    }

    @Override
    public void delete(Integer id) {
        bucketRepository.delete(id);
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }
}
