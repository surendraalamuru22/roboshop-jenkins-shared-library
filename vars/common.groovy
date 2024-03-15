def codeCheckout() {
    stage('Code Checkout') {
        sh 'find . | sed 1d | xargs rm -rf'
        git branch: 'main', url: "https://github.com/surendraalamuru22/${COMPONENT}.git"
    }
}


def codeQuality() {
    stage('code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
               sudo sonar-scanner -Dsonar.host.url=http://172.31.14.212:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.javascript.exclusions="*.js" -Dsonar.qualitygate.wait=true
        
            '''
        }
    }
}

def codechecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {

        stage('lint checks') {
            echo 'lint checks'
        }

        stage('unit tests') {
            echo 'unit tests'
        }

    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Download Dependencies') {
            echo 'Download Dependencies'
        }

        stage('Prepare Artifact') {
            echo 'Prepare Artifact'
        }

        stage('Publish Artifact') {
            echo 'Prublish Artifact'
        }

    }
}