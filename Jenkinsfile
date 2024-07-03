 

pipeline {
    agent {
        label 'ubuntu-latest'
    }
    stages {
        stage('Checkout code') {
            steps {
                checkout scmGit(branches: [[name: '**']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/melsnow/jenkins-tutorial']])
            }
        }

        stage('Build') {
            steps {
                // Use Maven to build the project
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Run tests using Maven
                sh 'mvn test'
            }
        }
    }
}