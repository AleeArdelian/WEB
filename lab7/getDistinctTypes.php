<?php
    $connection = mysqli_connect('localhost','root','');
    mysqli_select_db($connection, 'lab7');

    $query = "SELECT DISTINCT type FROM documents";
    $result = mysqli_query($connection, $query);

    while ($row = mysqli_fetch_array($result)) {
        echo $row['type'].";";
    }
    mysqli_close($connection);