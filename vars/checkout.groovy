def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
    }
  /*  
    stage ('Compile') {
      bat "mvn clean"
      bat "mvn install"
      bat "mvn package -DskipTests"
        }
    stage ('Scan-code') {
  
      sh 'sonar-scanner  ' +
      '-Dsonar.projectKey=$JOB_BASE_NAME ' +
      '-Dsonar.projectName=$JOB_BASE_NAME ' +
      '-Dsonar.projectVersion=1.0 ' +
      '-Dsonar.sources=$WORKSPACE/src ' +
      '-Dsonar.binaries=$WORKSPACE/ ' +
      '-Dsonar.java.binaries=$WORKSPACE/ '
      
        }
        */
    }
  }
