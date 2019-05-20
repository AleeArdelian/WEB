<?php
$connection = mysqli_connect('localhost','root','');
mysqli_select_db($connection, 'lab7');

$Type = $_GET['type'];
$query = "SELECT * FROM documents WHERE Type='$Type'";
$result = mysqli_query($connection, $query);

$i=0;

while($row = mysqli_fetch_array($result)){
    $final[$i]=$row['Id']."#".$row['Author']."#".$row['Title'].'#'.$row['NumberPages']."#".$row['Type']."#".$row['Format'];
    echo $final[$i].";";
    $i=$i+1;
}

mysqli_close($connection);
