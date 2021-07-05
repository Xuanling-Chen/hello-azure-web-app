pipeline {
    agent any

    stages {
        stage ('Checkout Stage') {
            steps{
                checkout scm
              }
            }
        stage ('Build Stage') {

            steps {

                  mvn clean install

            }
        }

        stage ('Testing Stage') {

            steps {
               // withMaven(maven : 'maven3.8.1') {
                   mvn test
               // }
            }
        }

        stage("Publish to Azure") {
            steps {
                azureWebAppPublish appName: "hello-azure-web-app",
                    azureCredentialsId: "e90fad6f-fc64-42c2-ae47-d449285b98c2",
                    publishType: "file",
                    filePath: "**/*.*",
                    resourceGroup: "jenkins-azure-rg",
                    sourceDirectory: "target/hello-azure-web-app-0.0.1-SNAPSHOT.jar"
            }
        }
    }
}