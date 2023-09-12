pipeline {
    agent any
    tools{
        maven "maven3"
    }
   

    stages {
        stage('Getting the project from GIT') {
            steps {
               echo 'Pulling..';
                git branch: 'main',
                url: 'https://github.com/akibirio/student-registration-app.git';
            }
        }
        
    stage('Cleaning the project') {
             
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'
            }
        }
        
    stage('Artifact Construction') {
             
            steps {
                echo "artificat contruction"
                sh 'mvn package'
            }
        }

                stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    echo "build successfull"
                }
            }
        }

    }
}