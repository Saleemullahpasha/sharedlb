def call(String repoUrl) {

pipeline {
       agent any
       tools {
           maven 'maven'
           jdk 'java-11'
       }
       stages {
           stage("Tools initialization") {
               steps {
                 bat  "mvn --version"
                 bat  "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                       url: "${repoUrl}"
               }
           }
           stage("Cleaning workspace") {
               steps {
                  bat "mvn clean"
               }
           }
           stage("Running Testcase") {
              steps {
                  bat "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                  bat "mvn package -DskipTests"
               }
           }
       }
   }
}
