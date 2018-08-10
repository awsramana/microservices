package com.i3.service.redis;

public interface MessagePublisher {
 void publish(final String message);
}
