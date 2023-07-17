<?php

// Database connection
$hostname = 'localhost';
$username = 'root';
$password = 'securepassword';
$db_name = 'happy_hounds';

// Establish connection to the server
$connection = mysqli_connect($hostname, $username, $password, $db_name);

// Function to sanitize user inputs
function sanitize_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Function to check if the user already exists
function check_existing_user($email) {
    global $connection;
    $sql = "SELECT email FROM users WHERE email = '$email'";
    $result = mysqli_query($connection, $sql);
    if (mysqli_num_rows($result) > 0) {
        return true;
    } else {
        return false;
    }
}

// Function to check if the username already exists
function check_existing_username($username) {
    global $connection;
    $sql = "SELECT username FROM users WHERE username = '$username'";
    $result = mysqli_query($connection, $sql);
    if (mysqli_num_rows($result) > 0) {
        return true;
    } else {
        return false;
    }
}

// Function to check if the email is valid
function check_email_address($email) {
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        return false;
    } else {
        return true;
    }
}

// Function to check if the username is valid
function check_username($username) {
    if (!preg_match('/^[A-Za-z0-9_.-]{3,15}$/', $username)) {
        return false;
    } else {
        return true;
    }
}

// Function to create a new user
function create_user($name, $email, $username, $password) {
    global $connection;
    $sql = "INSERT INTO users (name, email, username, password) VALUES ('$name', '$email', '$username', '$password')";
    $result = mysqli_query($connection, $sql);
    if ($result) {
        return true;
    } else {
        return false;
    }
}

// Function to get a particular user's details
function get_user_details($user_id) {
    global $connection;
    $sql = "SELECT * FROM users WHERE id = $user_id";
    $result = mysqli_query($connection, $sql);
    $data = mysqli_fetch_assoc($result);
    
    return $data;
}

// Function to update a user
function update_user($user_id, $name, $email, $username, $password) {
    global $connection;
    $sql = "UPDATE users SET name='$name', email='$email', username='$username', password='$password' WHERE id='$user_id'";
    $result = mysqli_query($connection, $sql);
    if ($result) {
        return true;
    } else {
        return false;
    }
}

// Function to delete a user
function delete_user($user_id) {
    global $connection;
    $sql = "DELETE FROM users WHERE id='$user_id'";
    $result = mysqli_query($connection, $sql);
    if ($result) {
        return true;
    } else {
        return false;
    }
}

// Function to get all users
function get_all_users() {
    global $connection;
    $sql = "SELECT * FROM users";
    $result = mysqli_query($connection, $sql);
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }
    return $data;
}

// Function to check login credentials
function check_login($username, $password) {
    global $connection;
    $sql = "SELECT * FROM users WHERE username='$username' AND password='$password'";
    $result = mysqli_query($connection, $sql);
    if (mysqli_num_rows($result) > 0) {
        return true;
    } else {
        return false;
    }
}

// Function to parse a date in the correct format
function parse_date($date) {
    $date_arr = explode('-', $date);
    $date_arr = array_map('intval', $date_arr);
    $date_arr[1]--;
    return date('Y-m-d', mktime(0, 0, 0, $date_arr[1], $date_arr[2], $date_arr[0]));
}

// Function to get users who are registered before a given date
function get_users_before_date($date) {
    global $connection;
    $date = parse_date($date);
    $sql = "SELECT id, name, username, email FROM users WHERE registered_at < '$date'";
    $result = mysqli_query($connection, $sql);
    while ($row = mysqli_fetch_assoc($result)) {
        $data[] = $row;
    }
    return $data;
}

?>