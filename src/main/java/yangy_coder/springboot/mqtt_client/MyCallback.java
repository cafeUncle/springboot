package yangy_coder.springboot.mqtt_client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MyCallback implements MqttCallback {

    private String clientId;

    public MyCallback() {
    }

    public MyCallback(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("connectionLost:" + throwable.toString());
    }

    @Override
    public void messageArrived(String topicFilter, MqttMessage mqttMessage) throws Exception {
        System.out.println("messageArrived:" + clientId);
        System.out.println("messageArrived:" + topicFilter);
        System.out.println("messageArrived:" + mqttMessage.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete:" + iMqttDeliveryToken.toString());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
