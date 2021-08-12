<%@page import="java.util.List" %>
<%@page import="com.ers.model.ReimbursementRequest" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>

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
                        <a class="navbar-brand" href="#">Reimbursement System</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                          <span class="navbar-toggler-icon"></span>
                        </button>
                      
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-employee-dashboard">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-employee-pending-reimbursement-requests">Pending request</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" href="/ReimbursementSystem/view-employee-resolved-reimbursement-requests">Resolved request</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-reimbursement-request-form">Request</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/ReimbursementSystem/view-employee-profile">Profile</a>
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
        <table class="table table-bordered">
            <thead class="table-dark text-light">
                <tr>
                    <th>Amount</th>
                    <th>Request Date</th>
                    <th>Status</th>
                    <th>Remark</th>
                </tr>
            </thead>
            <tbody>
            	<%
            		List<ReimbursementRequest> reimbursementRequestList=(List<ReimbursementRequest>)request.getAttribute("resolvedReimbursementRequests");
            		if(reimbursementRequestList!=null)	
            			for(ReimbursementRequest rr:reimbursementRequestList){
            	%>
            		<tr>
            			<td><%= rr.getAmount() %></td>
            			<td><%= rr.getRequestDateTime() %></td>
            			<td><%= rr.getStatus() %></td>
            			<td><%= rr.getRemark() %></td>
            		</tr>
            	<%
            			}
            	%>
            </tbody>
        </table>
    </section>
</body>
</html>