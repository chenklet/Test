package jms.spring;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Component;

@Component
public class SpringJMSConsumer2 {
	public void processMessage(String message) {
		PropertyConfigurator.configure("D:\\workspace\\Chapter3\\bin\\com\\learn\\ssm\\chapter3\\main\\log4j.properties");
		Logger logger = Logger.getLogger(SpringJMSConsumer2.class);
		logger.info("********************************************");
		logger.info(message);
	}
}
