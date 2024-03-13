def call() {
    node {
        agent {
            node { label 'workstation'}
        }

            if (! env.TAG_NAME) {
                env.TAG_NAME = ""
            }
//            sh 'env'
            common.codeQuality()
            common.stylechecks()
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