package jms.spring;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringConsumer {
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:\\workspace\\Chapter3\\bin\\com\\learn\\ssm\\chapter3\\main\\log4j.properties");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"E:\\git\\Test\\Study\\src\\jms\\resource\\spring.xml");
		SpringJMSConsumer consumer = context.getBean(SpringJMSConsumer.class);
		System.out.println(consumer.getMessage());
	}
}
