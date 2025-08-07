pipeline {
  agent {
    docker { 
        image 'ubuntu'
        args '-v ansible:/root/.ansible'
    }
    }
  stages {
    stage('Clone Repository') {
      steps {
        sh '''
          rm -rf avd-jenkins-demo
          git config --global http.proxy http://10.1.1.6:7890
          git config --global https.proxy http://10.1.1.6:7890
          git clone https://github.com/AbyssVoyager/avd-jenkins-demo.git
        '''
      }
    }
    stage('Run Playbook'){
        steps {
            script{
                dir('avd-jenkins-demo'){
            sh '''
            ansible-playbook deploy.yml
            '''
                }
            }
        }
    }
  }
}