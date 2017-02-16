package daggerok.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;

import java.math.BigInteger;

@Configuration

@Slf4j
@EnableBinding(Sink.class)
public class ConsumerConfig {

    static BigInteger counter = BigInteger.ZERO;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void logMessage(String message) {
        log.info("received {}: '{}'", counter = counter.add(BigInteger.ONE), message);
    }
}
