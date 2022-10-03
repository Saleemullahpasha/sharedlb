pipeline {
       agent any
       tools {
           maven 'maven'
           jdk 'java-11'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   mvn --version
                   java -version
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'master',
                       url: "https://github.com/Saleemullahpasha/hello-world.git"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                   sh "mvn package -DskipTests"
               }
           }
       }
 }
