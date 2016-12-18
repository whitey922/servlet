<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta login="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body id="registr_page">
<h1>Registration</h1>
<h2>${errorMessage.message}</h2>
<form action="registration" method="post">
    <input id="login" name="login" type="text" value="${user.login}" placeholder="login" pattern="\w{4,20}"/><br>
    <input id="password" name="password" type="text" value="${user.password}" placeholder="password" pattern="\w{8,20}"/><br>
    <input id="repeat_password" name="" type="text" placeholder="repeat password"/><br>
    <input id="email" name="email" type="text" placeholder="email"/><br>
    <input id="name" name="login" type="text" placeholder="login" pattern="\w{3,20}"/><br>
    <input id="surname" name="surname" type="text" placeholder="surname"/><br>
    <input id="phone" name="phone" type="text" placeholder="phone" pattern="^[+]{1}[\d]{12}"/><br>
    <input login="submit" type="submit">
</form>
</body>
</html>