package hu.czirko.SpringBoot_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public LocaleResolver localResolver(){
		AcceptHeaderLocaleResolver lr = new AcceptHeaderLocaleResolver();
		lr.setDefaultLocale(Locale.ENGLISH);
		return lr;
	}

	@Bean
	public ResourceBundleMessageSource bms(){
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages");
		return ms;
	}

}
