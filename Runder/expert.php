<!DOCTYPE html>
<!-- 
Final Project
CMPT 307 Databases
Westminster College
Fall 2016
M. Martinez
K. Ottmann
-->
<html class="nojs html css_verticalspacer" lang="en-US">
 <head>

  <meta http-equiv="Content-type" content="text/html;charset=UTF-8"/>
  <meta name="generator" content="2017.0.0.363"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  
  <title>Expert</title>
  <!-- CSS -->
  <link rel="stylesheet" type="text/css" href="css/site_global.css?crc=443350757"/>
  <link rel="stylesheet" type="text/css" href="css/master_a-master.css?crc=217699701"/>
  <link rel="stylesheet" type="text/css" href="css/expert.css?crc=360339756" id="pagesheet"/>
   </head>
 <body>
  
    <style type="text/css">
	  table, th, td {
		  border: 10px;
		  border-style: solid;
		  border-color: white;
		  text-align: center;
	  }
		
		th {
		font-weight: bold;
	}
	 </style>

  <div class="clearfix borderbox" id="page"><!-- column -->
   <div class="clearfix colelem" id="pu97"><!-- group -->
    <a class="nonblock nontext clip_frame grpelem" id="u97" href="index.html"><!-- image --><img class="block" id="u97_img" src="images/img_1340jpg.jpg?crc=4034780884" alt="" data-image-width="146" data-image-height="146"/></a>
    <a class="nonblock nontext clip_frame grpelem" id="u107" href="index.html"><!-- image --><img class="block" id="u107_img" src="images/img_0218jpg.jpg?crc=283841338" alt="" data-image-width="236" data-image-height="65"/></a>
   </div>
   <a class="nonblock nontext clip_frame colelem" id="u117" href="index.html"><!-- image --><img class="block" id="u117_img" src="images/img_0218jpg-1.jpg?crc=318415441" alt="" data-image-width="236" data-image-height="34"/></a>
   <div class="clip_frame colelem" id="u347"><!-- image -->
    <img class="block" id="u347_img" src="images/img_0215jpg.jpg?crc=3794145934" alt="" data-image-width="53" data-image-height="53"/>
   </div>
   <div class="clearfix colelem" id="u367-4"><!-- content -->

     <p><?php
$servername = "localhost";
$username = "kottmann";
$password = "Westminster";
$dbname = "RUNDER";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT Name, terrainName, medical, Runs.BackcountryTerrain_idBackcountryTerrain FROM Runs, Terrain WHERE Runs.terrainID = Terrain.terrainID AND Runs.difficulty_rating = 3 AND Runs.MountainId = Terrain.Resort_MountainID";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo '<table align="center"><tr><th>Name of Run</th><th>Terrain Area</th><th>Patrol Shack</th><th>Backcountry Gates</th></tr>';
    while($row = $result->fetch_assoc()) {
        echo '<tr><td>'.$row['Name'].'</td><td>'.$row['terrainName'].'</td><td>'.$row['medical'].'</td><td>'.$row['BackcountryTerrain_idBackcountryTerrain'].'</td></tr>';
    }
	echo '</table>';
} else {
    echo "0 results";
}
$conn->close();
?></p>
   </div>
   <div class="verticalspacer" data-offset-top="749" data-content-above-spacer="749" data-content-below-spacer="156"></div>
   <div class="clearfix colelem" id="u94-8"><!-- content -->
    <p>Westminster College<br/>Martinez/Ottmann<br/>CMPT 307 <br/>Fall 2016</p>
   </div>
  </div>
   </body>
</html>
