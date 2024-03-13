def codeQuality() {
    stage('code Quality') {
        echo 'code quality'
    }
}

def codechecks() {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {

        stage('lint checks') {
            echo 'lint checks'
        }

        stage('unit tests') {
            echo 'unit tests'
        }

    }
}

def artifacts() {
    if ( TAG_NAME ==~ ".*" ) {

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