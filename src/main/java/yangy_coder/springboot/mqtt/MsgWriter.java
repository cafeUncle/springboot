package yangy_coder.springboot.mqtt;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * 配置MessagingGateway
 */
@MessagingGateway(defaultRequestChannel = "outChannel")
public interface MsgWriter {
    void write(String note);
}