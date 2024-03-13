def call() {
    node {
        agent {
            node { label 'workstation'}
        }
            sh 'env'
            common.codeQuality()
            if ( BRANCH_NAME == "main" || tag ==~ "*" ) {
                stage('lint checks') {
                    echo 'lint checks'
                }
            }
//            stage ('unit tests') {
//                when {
//                    anyOf {
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//                steps {
//                    echo 'unit tests'
//                }
//            }
//            stage ('download dependencies') {
//                when { tag "*" }
//                steps {
//                    echo 'download dependencies'
//                }
//            }
//            stage ('prepare artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'prepare artifact'
//                }
//            }
//            stage ('publish artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'publish artifact'
//                }
//            }
    }
}