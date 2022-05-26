pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "rmdir  /s /q GPII"
                bat "git clone https://github.com/SergioErramuzpe/gpii.git"
                bat "mvn clean -f TicketBookingServiceJunitTesting"
            }
        }
        stage('build, analyze & compile') {
            steps {
                bat "./analisis_comp.sh"
            }
        }
        stage('test') {
            steps {
                bat "./test.sh"
            }
        }
    }
}