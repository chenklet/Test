package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TranJMSProductor {
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:\\workspace\\Chapter3\\bin\\com\\learn\\ssm\\chapter3\\main\\log4j.properties");
		Logger logger = Logger.getLogger(TranJMSProductor.class);
		ConnectionFactory cf = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination dest = new ActiveMQQueue("spitter.queue");
			MessageProducer producer = session.createProducer(dest);
			TextMessage msg = session.createTextMessage();
			msg.setText("Hello world");
			producer.send(msg);
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
