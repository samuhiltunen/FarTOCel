pipeline {
    agent any // Define an agent to execute the pipeline on any available executor

    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
    }
    
    stages {
        stage('Checkout') { // Define a stage for checking out the source code
            steps {
                script {
                    // Checkout the repository from GitHub
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/samuhiltunen/FarTOCel']]])
                }
            }
        }
        stage('Build') { // Define a stage for building the project
           steps {
               dir("FarTOCel/jenkins") {
                   bat 'mvn clean install' // Execute Maven command to clean and install dependencies
               }
           }
        }
        stage('Test') { // Define a stage for running tests
           steps {
               dir("FarTOCel/jenkins") {
                   bat 'mvn test' // Execute Maven command to run tests
               }
           }    
        }
    }

    post { // Define post-build actions
        success { // Define actions to be executed if the build is successful
            // Publish JUnit test results
            junit '**/target/surefire-reports/TEST-*.xml'
            // Generate JaCoCo code coverage report
            jacoco(execPattern: '**/target/jacoco.exec')
            // Send email notification on success
            emailext body: 'Latest build and integrations', subject: 'Test Status', to: 'samu.hiltunen@metropolia.fi'
        }
        always { // Define actions to be executed regardless of the build result
            // Always send email notification
            emailext body: 'Latest build and integrations', subject: 'Test Status', to: 'samu.hiltunen@metropolia.fi'
        }
    }
}
