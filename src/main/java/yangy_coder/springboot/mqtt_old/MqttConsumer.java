package yangy_coder.springboot.mqtt_old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;

/**
 * 配置 consumer
 */
//@Configuration
public class MqttConsumer {

    @Autowired
    MqttPahoClientFactory mqttPahoClientFactory;

    @Bean
    public IntegrationFlow mqttInFlow() {
        return IntegrationFlows.from(mqttInbound())
                .transform(p -> p + ", received from MQTT")
                .handle(logger())
                .get();
    }

    private LoggingHandler logger() {
        LoggingHandler loggingHandler = new LoggingHandler("INFO");
        loggingHandler.setLoggerName("mqttIntegrationDemo");
        return loggingHandler;
    }

    @Bean
    public MessageProducerSupport mqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("testClientConsumer",
                mqttPahoClientFactory, MqttConfiguration.topic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        return adapter;
    }
}
