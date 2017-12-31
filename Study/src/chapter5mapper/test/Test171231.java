package chapter5mapper.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import chapter5mapper.mapper.EmployeeMapper;
import chapter5mapper.vo.Employee;
import chapter5mapper.vo.FemaleEmployee;
import chapter5mapper.vo.MaleEmployee;

public class Test171231 {
	public static void main(String[] args) throws FileNotFoundException {
		String config = "mybatis-config.xml";
		FileInputStream resource = new FileInputStream("E:\\git\\Test\\Study\\src\\chapter5mapper\\test\\" + config);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
		EmployeeMapper mapper = factory.openSession().getMapper(EmployeeMapper.class);
		Employee me = mapper.getEmployee(123);
		System.out.println(me.getRealName());
		System.out.println(me.getSex());
		System.out.println(me.getWorkCard().getDepartment());
		System.out.println(me.getEmployeeTaskList().get(0).getTaskName());
		System.out.println(me.getBirthday());
		System.out.println(((MaleEmployee)me).getMaleHealthForm().getProstate());
		System.out.println();
		Employee test = mapper.getEmployee(456);
		System.out.println(test.getRealName());
		System.out.println(test.getBirthday());
		System.out.println(test.getSex());
		System.out.println(((FemaleEmployee)test).getFemaleHealthForm().getUterus());
		System.out.println(test.getWorkCard().getDepartment());
		System.out.println(test.getEmployeeTaskList().get(0).getTaskName());
	}
}
