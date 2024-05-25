<?php


// function to register user
function registerUser() {
  $servername= "localhost";
  $username = "root";
  $password = ""; 
  $db = "proverbs";
  $conn= new mysqli($servername,$username,$password,$db);

  $data = json_decode(file_get_contents("php://input"), true);

  $uname=$data['usernameEditText'];
  $password=$data['passwordEditText'];
  // $pwd=password_hash($password,PASSWORD_DEFAULT);
  $email=$data['emailEditText'];

  $isValidEmail = filter_var($email,FILTER_VALIDATE_EMAIL);
  if($conn){
      if(strlen($password) < 8){
        echo json_encode(array("result"=>"password must be atleast 8 characters"));

      }elseif($isValidEmail == false){
        echo json_encode(array("result"=>"this email is not valid"));
      }
      else{
          $checkusername = "SELECT * FROM users WHERE username LIKE '$uname'";
          $usernamequery = $conn->query($checkusername);

          $checkuseremail = "SELECT * FROM users WHERE email LIKE '$email'";
          $emailquery = $conn->query($checkuseremail);
          
          if($usernamequery -> num_rows > 0){
            echo json_encode("user already exist");
          }elseif($emailquery -> num_rows > 0){
              echo json_encode(array("result"=>"this email is already registered"));
          }
          else{
            $sql="INSERT INTO users(`username`,`email`,`password`)VALUES('$uname','$email','$password')";
            $result=$conn->query($sql);
            if($result){
              echo json_encode(array("result"=>"Successfully Registered"));
            }else{
              echo json_encode(array("result"=>"Registration Failed"));
            }
          }
        }
  }else{
    echo "Connection error";
  }
}


//function to contribute for a proverb
function contributeProverb() {
  $servername= "localhost";
  $username = "root";
  $password = ""; 
  $db = "proverbs";
  $conn = new mysqli($servername, $username, $password, $db);

  // Get data from the request body
  $data = json_decode(file_get_contents("php://input"), true);

  $proverbContent = $data['proverbText'];
  $category = $data['category'];
  $reference = $data['reference'];

  if ($conn) {
      if (strlen($proverbContent) < 10) {
          // Return error response as JSON
          echo json_encode(array("result" => "proverb must be at least 10 characters"));
      } else {
          $checkProverb = "SELECT * FROM contribution WHERE proverbContent LIKE '$proverbContent'";
          $proverbQuery = $conn->query($checkProverb);

          $checkReference = "SELECT * FROM contribution WHERE reference LIKE '$reference'";
          $referenceQuery = $conn->query($checkReference);
        
          if ($proverbQuery->num_rows > 0) {
              // Return error response as JSON
              echo json_encode(array("result" => "proverb already exists"));
          } elseif ($referenceQuery->num_rows > 0) {
              // Return error response as JSON
              echo json_encode(array("result" => "this reference is already registered"));
          } else {
              $sql = "INSERT INTO contribution (`proverbContent`, `reference`, `category`) VALUES ('$proverbContent', '$reference', '$category')";
              $result = $conn->query($sql);
              if ($result) {
                  // Return success response as JSON
                  echo json_encode(array("result" => "Successfully contributed"));
              } else {
                  // Return error response as JSON
                  echo json_encode(array("result" => "Contribution Failed"));
              }
          }
      }
  } else {
      // Return error response as JSON
      echo json_encode(array("result" => "Connection error"));
  }
}

// function to login
function loginUser() {

  $servername= "localhost";
  $username = "root";
  $password = ""; 
  $db = "proverbs";
  $conn= new mysqli($servername,$username,$password,$db);

  $data = json_decode(file_get_contents("php://input"), true);

  $password=$data['password'];
  $email=$data['email'];

  if($conn){
          $loginuser = "SELECT * FROM users WHERE email = '$email' AND password ='$password'";
          $isUserExist = $conn->query($loginuser);
          
          if($isUserExist -> num_rows > 0){
            echo json_encode(array("result"=>"Login Successfull !!!"));
          }else{
              echo json_encode(array("result"=>"Login Failed Please check your credentials"));
          } 
  }else{
    echo "DB Connection error";
  }
}

function getAllCategories(){

  $servername= "localhost";
  $username = "root";
  $password = ""; 
  $db = "proverbs";
  $conn= new mysqli($servername,$username,$password,$db);

  $data = json_decode(file_get_contents("php://input"), true);

  if($conn){
    $getCategoryName = "SELECT catName FROM category";
    $result = $conn->query($getCategoryName);

    $categories = array();
    if ($result->num_rows > 0) {
      // Fetch all category names
      while($row = $result->fetch_assoc()) {
          $categories[] = $row['catName'];
      }
  }
    echo json_encode(array("list"=>  $categories));
  }else{
    echo "DB Connection error";
  }
  
}

function getAllProverbs(){
  echo json_encode(array("list"=> 'hello'));
}
?>