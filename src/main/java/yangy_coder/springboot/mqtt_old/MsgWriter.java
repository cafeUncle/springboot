package yangy_coder.springboot.mqtt_old;

/**
 * 配置MessagingGateway
 */
//@MessagingGateway(defaultRequestChannel = "outChannel")
public interface MsgWriter {
    void write(String note);
}