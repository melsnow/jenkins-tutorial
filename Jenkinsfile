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
\
            steps {
                script {
                    // Run commands inside a Docker container
                    docker.image('cimg/openjdk:21.0.2-browsers').inside {
                        sh 'mvn clean'
                        sh 'mvn -Dtest=Integration test'
                    }
                }
            }
        }
    }
}
