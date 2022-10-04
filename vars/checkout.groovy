def call(String GITURL) {

node {
  env.NAMEMVC="${JOB_BASE_NAME}"
  env.NAMESPACE="integration"
  env.IMAGENAME="registry.local/msa/${JOB_BASE_NAME}"
  env.IMAGETAG="${BUILD_NUMBER}"
  env.WEB_LOCATION="$WORKSPACE/kubernetes/${JOB_BASE_NAME}"
  env.KUBECONFIG="$WORKSPACE/kubernetes/kubeconfig/staging"
  env.GITURL="https://github.com/Saleemullahpasha/tomcat-application.git"
  env.GIT_DIR_NAME="balance"


stage('Code Checkout'){

  cleanWs()
  git branch: '${GIT_BRANCH}', credentialsId: 'gitrepo', url: "$GITURL"

  sh "git rev-parse --short HEAD > .git/commit-id"
  //IMAGETAG= readFile('.git/commit-id').trim()
  sh 'echo $IMAGETAG'
  echo IMAGETAG

    }
  }
}
