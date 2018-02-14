package yangy_coder.springboot.mqttClient;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class MqttConsumer {
    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient("tcp://192.168.223.130:1883", "java_client_consumer", null);
            MyCallback callback = new MyCallback("java_client_consumer");
            client.setCallback(callback);
            MqttConnectOptions conOptions = new MqttConnectOptions();
            conOptions.setUserName("testuser");
            conOptions.setPassword("123456".toCharArray());
            conOptions.setCleanSession(false);
            client.connect(conOptions);
            client.subscribe("example", 1);
            Thread.sleep(10000);
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}