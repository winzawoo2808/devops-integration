pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/winzawoo2808/devops-integration']])
                sh "mvn clean install"
            }
        }

        stage('Build docker image') {
            steps {
                sh "docker build -t winzawoo/devops-integration ."
            }
        }
        stage('Push image to Hub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh "docker login -u winzawoo -p ${dockerhubpwd}"

                    sh "docker push winzawoo/devops-integration"
                }
            }
        }
    }
}
