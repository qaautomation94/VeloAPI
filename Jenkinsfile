pipeline {
  agent any
  stages {
    stage('Source') { // Get code
      steps {
        // get code from our Git repository
        git 'https://github.com/qaautomation94/VeloAPI'
      }
    }
    stage('Compile') { // Compile and do unit testing
      tools {
        maven 'Maven_Home'
      }
      steps {
        // run Gradle to execute compile and unit testing
        sh 'maven clean compile test'
      }
    }
  }
}