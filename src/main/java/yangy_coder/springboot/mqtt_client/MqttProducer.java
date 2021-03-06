package yangy_coder.springboot.mqtt_client;

import org.eclipse.paho.client.mqttv3.*;

public class MqttProducer {
    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient("tcp://192.168.1.200:1883","java_client_123123", null);
            MqttTopic topic = client.getTopic("example");
            MqttMessage message = new MqttMessage("Hello World. Hello Mq".getBytes());
            message.setQos(1);
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setUserName("testuser");
            mqttConnectOptions.setPassword("123456".toCharArray());
            client.connect(mqttConnectOptions);
            MqttDeliveryToken token = topic.publish(message);
            while (!token.isComplete()){
                token.waitForCompletion(1000);
            }
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
