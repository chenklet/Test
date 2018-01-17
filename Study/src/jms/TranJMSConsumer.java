package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TranJMSConsumer {
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:\\workspace\\Chapter3\\bin\\com\\learn\\ssm\\chapter3\\main\\log4j.properties");
		Logger logger = Logger.getLogger(TranJMSConsumer.class);
		ConnectionFactory cf = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination dest = new ActiveMQQueue("spitter.queue");
			MessageConsumer consumer = session.createConsumer(dest);
			Message message = consumer.receive();
			TextMessage msg = (TextMessage) message;
			logger.info("Got a message: " + msg.getText());
			conn.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (conn != null)
					conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
