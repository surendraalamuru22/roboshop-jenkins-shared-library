def call() {
   pipeline {
       agent any
       env.PIPELINE_NAME = "surendra"
       stages {
           stage('test stage') {
               steps {
                   sh 'echo name of the pipeline is $PIPE_LINE'
               }
           }
       }
   }
}