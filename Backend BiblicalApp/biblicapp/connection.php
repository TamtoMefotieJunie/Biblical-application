<?php
session_start();
include_once "conn.php";
if($_SERVER['REQUEST_METHOD'] == 'POST'){
$uname = $_POST['email'];
$pwd = $_POST['pwd'];
// $pass = password_hash($pwd,PASSWORD_DEFAULT);
$sql = "SELECT * FROM user WHERE email = '$uname'";

$result = $conn->query($sql);
if($result -> num_rows > 0){
    $user = mysqli_fetch_assoc($result);
    
    if(password_verify($pwd,$user['password'])){
        // $_SESSION['msg'] = [true, "Authentication successfull"];
        header('Location: Dashboard.php');
        die;
    }else{
        $_SESSION['msg'] = [false, "invalid email or password!"];
        header('Location: Login.php');
        die;
    }
}else{
    echo "not inserted".$sql."<br>".$conn->error;
    $_SESSION['msg'] = [true, "invalid email or password!"];
    header('Location: Login.php');

}


}
