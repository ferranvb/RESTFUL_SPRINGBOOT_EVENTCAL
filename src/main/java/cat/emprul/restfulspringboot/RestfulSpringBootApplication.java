package cat.emprul.restfulspringboot;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulSpringBootApplication.class, args);
	}
	
	/**
	 * In order for our application to be able to determine which locale is currently being used, we need to add a LocaleResolver bean:
	 * @return
	 */
//	@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver slr = new SessionLocaleResolver();
//		slr.setDefaultLocale(Locale.US);
//		return slr;
//	}
//	
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//	    lci.setParamName("lang");
//	    return lci;
//	}
}
