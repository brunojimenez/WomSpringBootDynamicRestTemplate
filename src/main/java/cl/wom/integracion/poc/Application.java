package cl.wom.integracion.poc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import lombok.var;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource("file:${APP_ENV}")
public class Application {

	@Bean
	public RestTemplate restTemplate(int timeout) {

		var requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(timeout);
		requestFactory.setReadTimeout(timeout);

		var restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(requestFactory);

		return restTemplate;
	}
}
