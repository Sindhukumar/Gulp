<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
    fieldset {
      border: 0;
    }
    label {
      display: block;
      margin: 30px 0 0 0;
    }
    .overflow {
      height: 200px;
    }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
 
    $( "#number" )
      .selectmenu()
      .selectmenu( "menuWidget" )
        .addClass( "overflow" );
  } );
  </script>
</head>
<body>
<h1>Hello User</h1>
<h2>Which restaurant would you like to review</h2>
 <form>
 <br><br>
 &nbsp Name of the Restaurant:<br> &nbsp<input type="text" name="rname" id="rname">
    <fieldset> 
    <label for="number">Rating</label>
    <select name="number" id="number">
      <option selected="selected">1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      </select>
 </fieldset>
 
 &nbsp Review:<br> &nbsp<input type="text" name="review" id="review" maxrows="5">
 </form>     
</body>
</html>