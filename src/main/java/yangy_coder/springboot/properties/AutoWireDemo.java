package yangy_coder.springboot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/**
 * 该注解用于指定路径和编码。没有中文时可以不加
 */
@PropertySource(value = {"classpath:application-dev.properties"}, encoding = "utf-8")
public class AutoWireDemo {

    @Value("${configuration.value1}")
    public static String value1;
    @Value("${value2}")
    public static String value2;

}
