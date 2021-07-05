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
                withMaven(maven : 'maven3.8.1') {
                    sh 'mvn clean install'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven3.8.1') {
                    sh 'mvn test'
                }
            }
        }

        stage("Publish to Azure") {
                steps{
                dir('target') {
                                    sh '''
                                        cp hello-azure-web-app-0.0.1-SNAPSHOT.jar hello-azure-web-app.jar
                                        '''
                                    zip zipFile: 'hello-azure-web-app.zip', glob: 'hello-azure-web-app.jar'

                                    azureWebAppPublish azureCredentialsId: 'e90fad6f-fc64-42c2-ae47-d449285b98c2',
                                            resourceGroup: 'app-service-rg',
                                            appName: 'hello-azure-web-app',
                                            filePath: "hello-azure-web-app.zip"
                                }

//                  azureWebAppPublish azureCredentialsId: "e90fad6f-fc64-42c2-ae47-d449285b98c2",
//                     resourceGroup: "app-service-rg",
//                     appName: "hello-azure-web-app",
//                     filePath: "target/hello-azure-web-app-0.0.1-SNAPSHOT.jar"
            }
        }
    }
}