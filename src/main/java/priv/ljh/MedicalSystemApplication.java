package priv.ljh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lijinghai
 * @MapperScan("priv.ljh.uniapp.mapper")  在项目启动类上加入@MapperScan注解，用于批量扫描
 */
@Slf4j
@MapperScan({"priv.ljh.uniapp.mapper","priv.ljh.pc.mapper"})
@SpringBootApplication
public class MedicalSystemApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MedicalSystemApplication.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(MedicalSystemApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
//        String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
//        log.info("\n----------------------------------------------------------\n\t" +
//                "Application lijinghai`s-boot is running! Access URLs:\n\t" +
//                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
//                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
//                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
//                "----------------------------------------------------------");
//    }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application lijinghai`s-boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port  + "/\n\t" +
                "External: \thttp://" + ip + ":" + port  + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port  + "/swagger-ui.html\n\t" +
                "Swagger2文档: \thttp://" + ip + ":" + port  + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
