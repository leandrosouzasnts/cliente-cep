package github.com.leandrosouzasnts.clientecep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClienteCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteCepApplication.class, args);
	}

}
