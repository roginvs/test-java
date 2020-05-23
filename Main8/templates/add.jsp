<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample Page</title>
</head>
<body>
    <h3>Create user</h3>
    <div>
        <form method="post">
            <div><input type="text" placeholder="Name" name="username" required/></div>
            <div><input type="password" placeholder="Password" name="password" required/></div>
            <div><button type="submit">Create</button>
        </form>
    </div>

    <div><br><a href="/">back</a></div>
</body>
</html>