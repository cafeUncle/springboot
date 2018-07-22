package yangy_coder.springboot.mqtt_client;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class MqttConsumer {
    public static void main(String[] args) {
        try {
            MqttClient client = new MqttClient("tcp://192.168.1.200:1883", "java_client_consumer", null);
            MyCallback callback = new MyCallback("java_client_consumer");
            client.setCallback(callback);
            MqttConnectOptions conOptions = new MqttConnectOptions();
            conOptions.setUserName("testuser");
            conOptions.setPassword("123456".toCharArray());
            conOptions.setCleanSession(false);
//            conOptions.setKeepAliveInterval(10000); //检查时间？
            /**
             * 调用后将保持连接，调用disconnect后断开
             */
            client.connect(conOptions);
            client.subscribe("example", 1);
            /**
             * 调用disconnect方法后断开连接
             */
//            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}