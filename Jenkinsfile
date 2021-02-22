pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/strangenewstar/browserstackdemo.git'
                sh './gradlew clean compileJava compileTestJava'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test -Dgroups=${TEST_GROUPS:=Browserstack}'
            }
        }
    }
}