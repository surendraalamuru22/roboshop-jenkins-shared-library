def codeQuality() {
    stage('code Quality') {
        echo 'code quality'
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