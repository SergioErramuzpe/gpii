pipeline {
    agent any
    stages {
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