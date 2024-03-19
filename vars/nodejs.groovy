def call() {
    node {
        agent {
            node { label 'workstation2'}
        }

//            sh 'env'
            common.codeCheckout()
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}