<%@page import="com.ers.model.Employee" %>
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
                                    <a class="nav-link" href="/ReimbursementSystem/view-employees">Employees</a>
                                </li>
                                 <li class="nav-item">
                                    <a class="nav-link active" href="/ReimbursementSystem/view-manager-profile">Profile</a>
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
    <section>
        <div class="container mt-5">
        	<% Employee employee=(Employee)request.getAttribute("profile-details"); %>
            <div class="row">
                <div class="col-md-12">
                    <h4 class="text-center">Edit Profile</h4>
                    <form action="/ReimbursementSystem/submit-manager-update-profile" method="post" class="mx-auto p-4 border" style="max-width: 600px;">
                        <div class="form-group mt-2">
                            <label for="name">Name</label>
                            <input type="text" value="<%=employee.getName() %>" class="form-control" name="name" id="name" placeholder="Name" required="required">
                        </div>
                        <div class="form-group mt-2">
                            <label for="email">Email</label>
                            <input type="email" value="<%=employee.getEmail() %>" class="form-control" name="email" id="email" placeholder="Email" required="required">
                        </div>
                        <div class="form-group mt-2">
                            <label for="phone-number">Phone Number</label>
                            <input type="number" value="<%=employee.getPhoneNumber() %>" class="form-control" name="phone-number" id="phone-number" placeholder="Phone Number" required="required">
                        </div>
                        <div class="form-group mt-2">
                            <label for="password">Password</label>
                            <input type="password" value="<%=employee.getPassword() %>" class="form-control" name="password" id="password" placeholder="Password" required="required">
                        </div>
                        <div class="form-group mt-2">
                            <input type="submit" class="btn btn-success" value="Update">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>