package daggerok.config;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;

import java.math.BigInteger;

import static java.lang.System.currentTimeMillis;

@Slf4j
@Configuration
@EnableBinding(Source.class)
public class ProducerConfig {

    @InboundChannelAdapter(Source.OUTPUT)
    public String currentTimeInMillis() {


        val greeting = "current time is: " + currentTimeMillis();

        log.info("producing: {}", greeting);
        return greeting;
    }
}
