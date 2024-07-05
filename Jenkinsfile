pipeline {
    agent {
       docker {
           image 'cimg/openjdk:21.0.2-browsers'
       }
    }
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
                sh 'mvn clean'
                sh 'mvn -Dtest=DockerChromeVncTest test'
            }
        }
    }
}
