import static org.junit.Assert.*;

import org.junit.Test;

import com.ers.service.EmployeeService;
import com.ers.service.EmployeeServiceImplementation;

public class EmployeeServiceTest {
	private EmployeeService employeeService=new EmployeeServiceImplementation();
	
	@Test
	public void validatePendingReiumbursementRequest() {
		assertNotNull(employeeService.getPendingReiumbursementRequest(2));
	}
	
	@Test
	public void validateResolvedReimbursementRequest() {
		assertNotNull(employeeService.getResolvedReimbursementRequest(2));
	}
	
	@Test
	public void validateLogin() {
		assertNotNull(employeeService.login("silvan8124@gmail.com", "1111"));
	}
}
