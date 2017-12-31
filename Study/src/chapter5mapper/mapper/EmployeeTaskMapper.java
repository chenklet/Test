package chapter5mapper.mapper;

import chapter5mapper.vo.EmployeeTask;

public interface EmployeeTaskMapper {
	public EmployeeTask getEmployeeTaskByEmpId(long empId);
}
