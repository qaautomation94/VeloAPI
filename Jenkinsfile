pipeline {
    agent any
     
    stages {
    
        stage('Compile Stage') { 
            steps {
                withMaven(maven : 'Maven_Home')
                sh 'mvn clean compile test'
            }
        }
        
    //    stage('Test Stage') { 
     //       steps {
               // withMaven(maven : 'Maven_Home')
       //         sh 'mvn test'
         //   }
        //}
       // stage('Deploy Stage') { 
         //   steps {
               //  withMaven(maven : 'Maven_Home')
           //      sh 'mvn deploy'
            //}
        //}
        
    }
}