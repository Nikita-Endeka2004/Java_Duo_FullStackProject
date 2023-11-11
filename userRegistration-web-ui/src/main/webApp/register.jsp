<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration Page</title>
</head>
<body>
<h2>Registration Form</h2>
<form action="/userRegistration/registrationServlet" method="POST">
    <label for="registrationEmail">Email</label>
    <input name="email" type="email" class="form-control" id="registrationEmail" aria-describedby="emailHelp" placeholder="gg@gmail.com">
    <label for="registrationPassword">Password</label>
    <input name="password" type="password" class="form-control" id="registrationPassword" placeholder="Password">
    <label for="registrationName">Name</label>
    <input name="name" type="text" class="form-control" id="registrationName" placeholder="Name">
    <label for="registrationSurname">Surname</label>
    <input name="surname" type="text" class="form-control" id="registrationSurname" placeholder="Surname">
    <label for="registrationGender">Gender</label>
    <input name="gender" type="text" class="form-control" id="registrationGender" placeholder="Gender">

    <input type="submit" value="Registrate">
</form>
</body>
</html>