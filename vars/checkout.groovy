def call(String repoUrl) {

  node{
    
    env.IMAGETAG="${BUILD_NUMBER}"  
    stage('Code Checkout'){
      cleanWs()
      git branch: '${GIT_BRANCH}', url: "$repoUrl"
      //IMAGETAG= readFile('.git/commit-id').trim()
      sh 'echo $IMAGETAG'
      echo IMAGETAG
    } 
  }
}
