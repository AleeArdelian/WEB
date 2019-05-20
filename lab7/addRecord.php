<?php
session_start();
    $connection = mysqli_connect('localhost','root','');
    mysqli_select_db($connection, 'lab7');


    if(isset($_POST['save'])){
        $id = mysqli_real_escape_string($connection, $_POST['id']);
        $author = mysqli_real_escape_string($connection, $_POST['author']);
        $title = mysqli_real_escape_string($connection, $_POST['title']);
        $nrPages = mysqli_real_escape_string($connection, $_POST['nrPage']);
        $type = mysqli_real_escape_string($connection, $_POST['type']);
        $format = mysqli_real_escape_string($connection, $_POST['format']);

        $sql = "INSERT INTO documents(Id,Author, Title,NumberPages,Type,Format)
        VALUES ('$id','$author','$title','$nrPages','$type','$format')";

        $result = mysqli_query($connection,$sql);
        header('location: index.html');
    }

    if(isset($_POST['delete'])) {
        $id = mysqli_real_escape_string($connection, $_POST['id']);
    //    $author = mysqli_real_escape_string($connection, $_POST['author']);
    //    $title = mysqli_real_escape_string($connection, $_POST['title']);
    //    $nrPages = mysqli_real_escape_string($connection, $_POST['nrPage']);
    //    $type = mysqli_real_escape_string($connection, $_POST['type']);
    //    $format = mysqli_real_escape_string($connection, $_POST['format']);

        $sql = "DELETE FROM documents WHERE Id = '$id'";  //"'$author','$title','$nrPages','$type','$format')";
        $result = mysqli_query($connection, $sql);
        header('location: index.html');
    }
    if(isset($_POST['update'])) {
        $id = mysqli_real_escape_string($connection, $_POST['id']);
        $author = mysqli_real_escape_string($connection, $_POST['author']);
        $title = mysqli_real_escape_string($connection, $_POST['title']);
        $nrPages = mysqli_real_escape_string($connection, $_POST['nrPage']);
        $type = mysqli_real_escape_string($connection, $_POST['type']);
        $format = mysqli_real_escape_string($connection, $_POST['format']);

        $sql = "UPDATE documents SET Author= '$author', Title = '$title', NumberPages = '$nrPages',Type='$type',Format='$format' WHERE Id = '$id'";
        $result = mysqli_query($connection, $sql);
        header('location: index.html');
    }
