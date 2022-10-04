def call(String repoUrl) {

  node{
    
    env.IMAGETAG="${BUILD_NUMBER}"  
    stage('Code Checkout'){
      cleanWs()
      git branch: '${GIT_BRANCH}', credentialsId: 'gitrepo', url: "$repoUrl"
      sh "git rev-parse --short HEAD > .git/commit-id"
      //IMAGETAG= readFile('.git/commit-id').trim()
      sh 'echo $IMAGETAG'
      echo IMAGETAG
    } 
  }
}
