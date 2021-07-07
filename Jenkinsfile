pipeline {
    agent any
    parameters {
        string(name: 'azure_cred_id', defaultValue: '82407b79-7755-4e97-aa2b-137eb00e020c',
            description: 'azure credential')
        string(name: 'res_group', defaultValue: 'res_group',
                        description: 'resource group')
        string(name: 'app-service-name', defaultValue: 'app-service-name',
                                description: 'app-service-name')
        }
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

                    azureWebAppPublish azureCredentialsId: "${azure_cred_id}",
                          resourceGroup: "${res_group}",
                          appName: "${app-service-name}",
                          filePath: "hello-azure-web-app-0.0.1-SNAPSHOT.jar",
                          sourceDirectory: "target"

//                  azureWebAppPublish azureCredentialsId: "e90fad6f-fc64-42c2-ae47-d449285b98c2",
//                     resourceGroup: "app-service-rg",
//                     appName: "hello-azure-web-app",
//                     filePath: "target/hello-azure-web-app-0.0.1-SNAPSHOT.jar"
            }
        }
    }
}