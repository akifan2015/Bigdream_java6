package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.config.CryptionAES;
import com.example.config.StorageProperties;
import com.example.service.StorageService;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(StorageProperties.class)
public class MollaShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MollaShopApplication.class, args);
		System.out.println("url->" + CryptionAES.encrypt(
				"jdbc:sqlserver://localhost;databaseName=MollaShopSpringBootAndThymeleaf;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2",
				"MollaShopSpringBootAndThymeleaf"));
		System.out.println("userName->" + CryptionAES.encrypt("sa", "MollaShopSpringBootAndThymeleaf"));
		System.out.println("pass->" + CryptionAES.encrypt("123", "MollaShopSpringBootAndThymeleaf"));
		System.out
				.println("email " + CryptionAES.encrypt("huynhhuutinh0948@gmail.com", "MollaShopSpringBootAndThymeleaf"));
		System.out
				.println("pass " + CryptionAES.encrypt("qbyjsxyqvygajoab", "MollaShopSpringBootAndThymeleaf"));
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args -> {
			storageService.init();
		});
	}

}
