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
    <header class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
          
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/ReimbursementSystem/manager/home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ReimbursementSystem/manager/view-pending-reimbursement-requests.jsp">Pending request</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/ReimbursementSystem/manager/view-resolved-reimbursement-requests.jsp">Resolved request</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ReimbursementSystem/manager/view-employees.jsp">Employees</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ReimbursementSystem/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <section class="container mt-4">
        <table class="table table-bordered">
            <thead class="table-dark text-light">
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Amount</th>
                    <th>Request Date</th>
                    <th>Status</th>
                    <th>Remark</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </section>
</body>
</html>