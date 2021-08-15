<%@page import="com.ers.model.Employee" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display employees</title>

    <!--Stylesheet-->
    <!--Custom-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
            crossorigin="anonymous">
</head>
<body>
    <header class="bg-primary">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                      
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-manager-dashboard">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-manager-pending-reimbursement-requests">Pending request</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-manager-resolved-reimbursement-requests">Resolved request</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" href="/ReimbursementSystem/view-employees">Employees</a>
                                </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-manager-profile">Profile</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/logout">Logout</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <section class="container mt-4">
    	<a href="/ReimbursementSystem/view-employee-form" class="btn btn-success mb-3">Add employee</a>
        <table class="table table-bordered">
            <thead class="table-dark text-light">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Department</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
            	<%
            		List<Employee> employeeList=(List<Employee>)request.getAttribute("employeeList");
            		if(employeeList!=null)
            			for(Employee employee:employeeList){
            	%>
            		<tr>
            			<td><%=employee.getId() %></td>
            			<td><%=employee.getName() %></td>
            			<td><%=employee.getEmail() %></td>
            			<td><%=employee.getPhoneNumber() %></td>
            			<td><%=employee.getDepartment() %></td>
            			<td>
            				<form action="/ReimbursementSystem/view-reimbursement-request-of-one-employee" method="post">
            					<input type="hidden" name="employee-id" value="<%=employee.getId()%>">
            					<input type="submit" class="btn btn-success" value="Requests">
            				</form>
            			</td>
            		</tr>
            	<%
            			}
            	%>
            </tbody>
        </table>
    </section>
</body>
</html>