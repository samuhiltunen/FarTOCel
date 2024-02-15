pipeline {
    agent any

    environment {
        PATH = "${env.PATH};C:\\Windows\\System32"
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/samuhiltunen/FarTOCel']]])
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Before changing directory: ${pwd()}"
                    dir("Metropolia_Samu/Ohtu/FarTOCel") {
                        echo "After changing directory: ${pwd()}"
                        // Execute Maven command
                        bat 'mvn clean install'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Change to the project directory
                    dir("Metropolia_Samu/Ohtu/FarTOCel") {
                        // Execute Maven command
                        bat 'mvn test'
                    }
                }
            }
        }
    }

    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            jacoco(execPattern: '**/target/jacoco.exec')
            emailext body: 'Latest build and integrations', subject: 'Test Status', to: 'samu.hiltunen@metropolia.fi'
        }
        always {
            emailext body: 'Latest build and integrations', subject: 'Test Status', to: 'samu.hiltunen@metropolia.fi'
        }
    }
}
