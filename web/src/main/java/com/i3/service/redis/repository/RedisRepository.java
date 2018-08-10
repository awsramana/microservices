package com.i3.service.redis.repository;

import java.util.Map;

import com.i3.service.redis.vo.Payment;

public interface RedisRepository {
	Map<Object, Object> findAllPayments();

	void add(Payment payment);

	void delete(String id);

	Payment findPayment(String id);
}
