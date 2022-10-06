def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
    }
    
    stage ('Compile') {
      bat "mvn clean"
      bat "mvn install"
      bat "mvn package -DskipTests"
        }
    stage ('Scan-code') {
   
      echo "SonarQube Test Start"
      
        }
    stage ('Docker') {
   
      echo "SonarQube Test Start"
      
        }
    stage ('Kubernetes') {
   
      echo "SonarQube Test Start"
      
        }
       
    }
  }
