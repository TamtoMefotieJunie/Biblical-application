<?php
session_start();
$msg = $_SESSION['msg'];

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/fontawesome/css/fontawesome.css" rel="stylesheet">
    <link href="assets/fontawesome/css/solid.css" rel="stylesheet">
    <link href="assets/fontawesome/css/brand.css" rel="stylesheet">
   
    <title>My first site in level2</title>
    <style>
        .container{
            width:100%;
            height:160px;
            background-color:#80aadf96;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .logo_container{
            width: 75%;
            height: 85%;
            background-color: #00000000;
            display: flex;
            align-items: center;
            font-size: xx-large;
            font-weight: 900;
            color: white;
        
        }
        .nav_container{
            width: 25%;
            height: 70%;
            background-color:#00000000;
            padding: 15px;
            padding-right: 20px;
            box-sizing: border-box;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .nav_container a{
            text-decoration: none;
        }
        .logo_container img{
            height: 90%;
        border-radius: 10%;
        margin-left: 15px;
        margin-right: 10px;
        }
        .btn{
            width: 30%;
            height: 30px;
            padding: 0px;
            text-decoration: solid;
            font-weight: 600;
            padding-top: 5px;
            text-align: center;
            justify-content: center;
            background-color: #80aadf96;
        }
        .active{
            background-color: silver;
            color: white;
        }
        .active a{
            color: white;
        }
        .registration{
            width: 500px;
            height: 550px;
            background-color: transparent;
            position: fixed;
            top: 32%;
            left: 40%;
        }
        form{
            width: 100%;
            height: 80%;
            background-color: transparent;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px, rgba(0, 0, 0, 0.3) 0px 30px 60px -30px, rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
            box-sizing: border-box;
            padding: 8%;
        }
        form input{
            width: 100%;
            height: 15%;
           color: black;
           box-sizing: border-box;
           border-radius: 10px;
          border: none;
            padding-left: 10px;
            margin-top: 10%;
            background-color: #f1f1f1;
            font-size: medium;
            
        }
        button{
         
            width: 50%;
            height: 10%;
            margin-left: 25%;
            margin-top: 20%;
            background-color:#80aadf96;
            border: none;
            font-size: large;
            font: bold;
            border-radius: 40px;
        }
        input :focus{
            border: solid #555555;
        }
        form p{
            text-align: center;
            text-decoration: solid;
            font-size: large;
            font-weight: 900;
            color: 	rgb(0, 128, 255);
            
        }
    </style>
</head>. 

<body>
    <div class="container">
        <div class= "logo_container">
            <img src="assets/images/Untitled.jpeg"/>
            <h1>smart park</h1>
        </div>
        <div class="nav_container" >
            <div class="active btn">
               <i class="fa-solid fa-house"></i> 
                <a href="./Dashboard.php">HOME</a>
            </div>
            <div class="btn">
            <i class="fa-solid fa-book"></i>
                <a href="./about.php">ABOUT</a></div>
            <div class="btn">
                <i class="fa-solid fa-phone"></i>
                <a href="./contact.php">CONTACT</a></div>
        </div>
        
    </div>
    <div class="registration">
            <form action="connection.php" method="POST">
                <p>SIGN IN HERE</p>
   
                <input type="text" name="email" placeholder="Email" required>
            <span class="error" id="email-error">
            <?php
            if(isset($msg)){
                if($msg[0]){
                    echo '<h3 style = "color: green">'. $msg[1] . '</h3>';
                    unset($_SESSION['msg']);
                }else{
                    echo '<h3 style = "color: red">'. $msg[1] . '</h3>';
                    unset($_SESSION['msg']);

                }
            }
            ?>
            </span>
            <input type="text" name="pwd" placeholder="password" required>
            <span class="error" id="password-error">
            <?php
            if(isset($msg)){
                if($msg[0]){
                    echo '<h3 style = "color: green">'. $msg[1] . '</h3>';
                    unset($_SESSION['msg']);
                }else{
                    echo '<h3 style = "color: red">'. $msg[1] . '</h3>';
                    unset($_SESSION['msg']);

                }
            }
            ?>
            </span>
           
       
            <button value="submit">SIGN IN</button>
            </form>
        </div>
</body>
</html>