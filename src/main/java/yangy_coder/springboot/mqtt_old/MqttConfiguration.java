package yangy_coder.springboot.mqtt_old;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

//@Configuration
//@IntegrationComponentScan
public class MqttConfiguration {

    @Value("${mqtt.brokerHost}")
    private String brokerHost;
    @Value("${mqtt.port}")
    private String port;
    @Value("${mqtt.username}")
    private String username;
    @Value("${mqtt.password}")
    private String password;
    @Value("${mqtt.topic}")
    public static String topic = "lalala";

    //配置client factory
    @Bean
    public static MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs("tcp://192.168.223.130:1883");
        factory.setUserName("testuser");
        factory.setPassword("123456");
        return factory;
    }

}