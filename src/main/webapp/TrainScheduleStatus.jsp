<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NTES</title>
 <link rel="stylesheet" href="TrainScheduleStatus.css">

</head>
<body>
<form action="TrainScheduleStatusURL"method="post">
<h1>National Train Enquiry System</h1>
<h2>Sport Your Train</h2>

<div class="container">
      <label for="uname"><b>Train No./Name</b></label><br></br>
      <input type="text" placeholder="Train No./Name" name="tnumber"size="96">
                 <input type="reset"value="cancel">
         <input type="submit"value="Find">
      
      </div>

</form>
</body>
</html>