package i3.i3redis.queue;

public interface MessagePublisher {

    void publish(final String message);
}
