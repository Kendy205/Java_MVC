package vn.hoidanit.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Bỏ kết nối DB
//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
//        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
//})
// Bỏ security
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class LaptopshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopshopApplication.class, args);
		// ApplicationContext abc = SpringApplication.run(LaptopshopApplication.class,
		// args);
		// for(String beanName : abc.getBeanDefinitionNames())
		// {
		// System.out.println(beanName); ===> BEANS
		// }
	}

}
