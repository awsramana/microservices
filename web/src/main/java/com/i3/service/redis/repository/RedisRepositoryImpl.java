package com.i3.service.redis.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.i3.service.redis.vo.Payment;
@Repository
public class RedisRepositoryImpl implements RedisRepository {
	 private static final String KEY = "Payment";

	 
	    private RedisTemplate<String, Object> redisTemplate;
	    private HashOperations hashOperations;
	    
	    @Autowired
	    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
	        this.redisTemplate = redisTemplate;
	    }
	    

	
	  @PostConstruct
	 private void init() {
		  hashOperations=redisTemplate.opsForHash();
	 }
	  
	
	@Override
	public Map<Object, Object> findAllPayments() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void add(Payment payment) {
		hashOperations.put(KEY, payment.getId(), payment.getName());

	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);

	}

	@Override
	public Payment findPayment(String id) {
		
		return (Payment)hashOperations.get(KEY, id);
	}

}
