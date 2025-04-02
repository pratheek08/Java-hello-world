pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "igris08/helloworld-java:latest"
        KUBE_DEPLOYMENT = "deployment.yaml"
        KUBE_SERVICE = "service.yaml"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/pratheek08/helloworld-java.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $DOCKER_IMAGE ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'docker-cred', url: '']) {
                        sh "docker push $DOCKER_IMAGE"
                    }
                }
            }
        }

    }

    post {
        success {
            echo "Deployment Successful! 🎉"
        }
        failure {
            echo "Deployment Failed! ❌"
        }
    }
}
