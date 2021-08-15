import static org.junit.Assert.*;


import org.junit.Test;

import com.ers.service.ManagerService;
import com.ers.service.ManagerServiceImplementation;

public class ManagerServiceTest {
	private ManagerService managerService=new ManagerServiceImplementation();
	
	@Test
	public void validatePendingReiumbursementRequest() {
		assertNotNull(managerService.getPendingReiumbursementRequest());
	}
	
	@Test
	public void validateResolvedReimbursementRequest() {
		assertNotNull(managerService.getResolvedReimbursementRequest());
	}
	
	@Test
	public void validateReimbursementRequestOfOneEmployee() {
		assertNotNull(managerService.getReimbursementRequestOfOneEmployee(2));
	}
	
	@Test
	public void validateLogin() {
		assertNotNull(managerService.login("manager@gmail.com", "1111"));
	}
}
