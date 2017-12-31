package chapter5mapper.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import chapter5mapper.mapper.EmployeeMapper;
import chapter5mapper.vo.Employee;
import chapter5mapper.vo.FemaleEmployee;
import chapter5mapper.vo.MaleEmployee;

public class Test171231 {
	public static void main(String[] args) throws FileNotFoundException {
		PropertyConfigurator.configure("D:\\workspace\\Chapter3\\bin\\com\\learn\\ssm\\chapter3\\main\\log4j.properties");
		Logger logger = Logger.getLogger(Test171231.class);
		String config = "mybatis-config.xml";
		FileInputStream resource = new FileInputStream("E:\\git\\Test\\Study\\src\\chapter5mapper\\test\\" + config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
		EmployeeMapper mapper = factory.openSession().getMapper(EmployeeMapper.class);
		Employee me = mapper.getEmployee(123);
		logger.info(me.getRealName());
		logger.info(me.getSex());
		logger.info(me.getWorkCard().getDepartment());
		logger.info(me.getEmployeeTaskList().get(0).getTaskName());
		logger.info(me.getBirthday());
		logger.info(((MaleEmployee)me).getMaleHealthForm().getProstate());
		logger.info("\n");
		Employee test = mapper.getEmployee(456);
		logger.info(test.getRealName());
		logger.info(test.getBirthday());
		logger.info(test.getSex());
		logger.info(((FemaleEmployee)test).getFemaleHealthForm().getUterus());
		logger.info(test.getWorkCard().getDepartment());
		logger.info(test.getEmployeeTaskList().get(0).getTaskName());
	}
}
