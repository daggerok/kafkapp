package daggerok.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;

import java.math.BigInteger;

import static java.lang.System.currentTimeMillis;

@Configuration

@Slf4j
@EnableBinding(Sink.class)
public class ConsumerConfig {

    static BigInteger counter = BigInteger.ZERO;
    static long latest = -1;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void logMessage(String payload) {

        if (latest > 0 && currentTimeMillis() - latest > 100L) {

            log.info("statistics collect finished.");
            System.exit(0);
        }

        log.info("{}) payload: '{}', latest: {}",
                counter = counter.add(BigInteger.ONE), payload, latest = currentTimeMillis());
    }
}
