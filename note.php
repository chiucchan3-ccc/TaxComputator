<?php
  // 1. Create a database connection
  $dbhost = "localhost";
  $dbuser = "root";
  $dbpass = "";
  $dbname = "ast20401";
  $connection = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
  // Test if connection succeeded
  if(mysqli_connect_errno()) {
    die("Database connection failed: " . 
         mysqli_connect_error() . 
         " (" . mysqli_connect_errno() . ")"
    );
  }
?>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Page title goes here ..</title>
</head>
<body>
<?php
$query =  "SELECT * ";
$query .= "FROM notes ";
$query .= "WHERE id = " . $_GET["id"];
echo "DEBUG - SQL query to execute: " . $query;

$result = mysqli_query($connection, $query);

if ($note = mysqli_fetch_assoc($result)) {
	
	echo "<h2>" . $note["subject"] . "</h2>";
	echo "<hr>";
	echo "<p>" . $note["details"] . "</p>";
	echo "<hr>";
	echo "<i>" . $note["date_created"] . "</i>";
	echo "<br><br><br>";
	echo '<a href="./notes.php">Back</a>';
}

mysqli_free_result($result);

mysqli_close($connection);

?>
</body>
</html>
