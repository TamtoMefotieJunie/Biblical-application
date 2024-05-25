<?php
session_start();

   
include_once('functions.php');

// block of code to register user
$request_uri = explode("/",$_SERVER['REQUEST_URI']);
$actualUri = "/".$request_uri[count($request_uri)-1];
$request_method = $_SERVER['REQUEST_METHOD'];

if($request_method === 'POST'){
  if($actualUri == "/register"){
          registerUser();
    }else if($actualUri == '/login'){
          loginUser();
    }else if($actualUri == '/contribution'){
          contributeProverb();
    }
}


if($request_method === 'GET'){
  if($actualUri == "/category"){
          getAllCategories();
    }else if($actualUri == '/proverbs'){
          getAllProverbs();
    }
}

// switch($request_method){
//   case 'POST':
//     if($request_uri == "/register"){
//       registerUser();
//       break;
//     }else if($request_uri == '/login'){
//       loginUser();
//       break;
//     }

//   case 'GET':
//     break;
  
//   default:
//     break;
// }




    // $sql="INSERT INTO user(`name`,`email`,`password`)VALUES('$uname','$email','$pwd')";
    // $result=$conn->query($sql);


    // if($result){
    //     $_SESSION['msg'] = [true, "User Created Successfuly"];
    //     header("Location: Login.php");
    //     die;
      
    // }else{
    
    // echo "not inserted".$sql."<br>".$conn->error;
    // $_SESSION['msg']=[false, "user creation failed"];
    
    
    // }
    // $conn->close();

    ?>






