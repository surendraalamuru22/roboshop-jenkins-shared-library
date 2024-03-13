def codeQuality() {
    stage('code Quality') {
        echo 'code quality'
    }
}

def stylechecks() {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*" ) {
        stage('lint checks') {
            echo 'lint checks'
        }
    }
}