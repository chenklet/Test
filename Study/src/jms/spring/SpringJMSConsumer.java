package jms.spring;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

@Component
public class SpringJMSConsumer {
	
	@Resource
	private JmsTemplate jmsTemplate;
	
	public String getMessage() {
		try {
			return ((TextMessage)jmsTemplate.receive("spittle.queue")).getText();
		} catch (JMSException e) {
			//change it as non-checked exception
			throw JmsUtils.convertJmsAccessException(e);
		}
	}
	
}
