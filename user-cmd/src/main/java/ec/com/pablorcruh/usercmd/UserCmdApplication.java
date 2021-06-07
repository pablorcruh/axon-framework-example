package ec.com.pablorcruh.usercmd;

import com.example.usercore.configuration.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class UserCmdApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCmdApplication.class, args);
    }

}
