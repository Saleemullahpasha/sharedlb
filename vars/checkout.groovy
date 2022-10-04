def call(String repoUrl) {

  node{
    
    env.IMAGETAG="${BUILD_NUMBER}"  
    stage('Code Checkout'){
      cleanWs()
      git branch: '${GIT_BRANCH}', url: "$repoUrl"
    } 
  }
}
