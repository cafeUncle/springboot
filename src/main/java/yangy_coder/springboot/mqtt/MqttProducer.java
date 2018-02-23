package yangy_coder.springboot.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.stream.CharacterStreamReadingMessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * 配置producer
 */
//@Configuration
public class MqttProducer {

    @Autowired
    MqttPahoClientFactory mqttPahoClientFactory;

    @Bean
    public IntegrationFlow mqttOutFlow() {
        //console input
    return IntegrationFlows.from(CharacterStreamReadingMessageSource.stdin(),
        e -> e.poller(Pollers.fixedDelay(1000)))
        .transform(p -> p + " sent to MQTT")
        .handle(mqttOutbound())
        .get();
//        return IntegrationFlows.from(outChannel())
//                .handle(mqttOutbound())
//                .get();
    }

    @Bean
    public MessageChannel outChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("testClientProducer", mqttPahoClientFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(MqttConfiguration.topic);
        return messageHandler;
    }

}
