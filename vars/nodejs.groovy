def call() {
    node {
        agent {
            node { label 'worker:node1'}
        }

//            sh 'env'
            common.codeCheckout()
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}