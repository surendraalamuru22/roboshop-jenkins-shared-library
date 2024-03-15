def call() {
    node {
        agent {
            node { label 'workstation'}
        }
//        stages {
//            stage ('compile code') {
//                steps {
//                    echo 'compile code'
//                }
//            }
            common.codeQuality()
//            stage ('lint checks') {
//                when {
//                    anyOf {
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//                steps {
//                    echo 'lint checks'
//                }
//            }
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
//            stage ('Build package') {
//                when { tag "*" }
//                steps {
//                    echo 'Build package'
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
//        }
    }
}