package jms.spring;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class SpringJMSProducer {
	
	@Resource
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final String msg) {
		jmsTemplate.send("spittle.queue", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
			
		});
	}
}
