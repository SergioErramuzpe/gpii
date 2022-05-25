<?php
    class User {
        public $username;
        public $isAdmin;

        public function PrintData () {
            if ($this->isAdmin) {
                echo $this->username . " is an admin";
            } else {
                echo $this->username . " is not an admin";
            }
        }
    }

    //$obj = new User();
    //$obj->username = "ippsec";
    //$obj->isAdmin = true;
    $obj = unserialize($_POST['ippsec']);
    $obj->PrintData();
?>