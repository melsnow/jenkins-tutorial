pipeline {
    agent any
    environment {
        APPLITOOLS_BATCH_ID = "${env.GIT_COMMIT}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                bat 'mvn clean'
                bat 'mvn -Dtest=Sample test'
            }
        }
    }
}
