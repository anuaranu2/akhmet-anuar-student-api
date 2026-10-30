
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'akhmet-anuar-student-api'
        IMAGE_TAG = 'v1.0-akhmet-anuar'
    }

    options {
        timestamps()
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Student: Anuar Akhmet'
                echo 'Stage 1: Checkout from GitHub'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Stage 2: Building Spring Boot Student API'
                sh 'chmod +x gradlew'
                sh './gradlew clean assemble --no-daemon'
            }
        }

        stage('Test') {
            steps {
                echo 'Stage 3: Running automated tests'
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit allowEmptyResults: true,
                          testResults: 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Stage 4: Building Docker image'
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }

        stage('Verify') {
            steps {
                echo 'Stage 5: Verifying Docker image'
                sh 'docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} --format "{{.Id}}"'
                echo 'Anuar Akhmet: Docker image verified'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Anuar Akhmet Student API CI pipeline completed!'
        }
        failure {
            echo 'FAILED: Anuar Akhmet Student API CI pipeline failed!'
        }
    }
}
