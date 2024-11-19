//def call() {
//    env.PIPELINE_NAME = "surendra"
//   pipeline {
//       agent any
//
//       stages {
//           stage('test stage') {
//               steps {
//                   sh 'echo name of the pipeline is $PIPELINE_NAME'
//               }
//           }
//       }
//   }
//}

def call() {
    node {
        agent any
         stage('test') {
            sh 'echo hello world'
         }
    }
}