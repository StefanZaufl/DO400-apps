pipeline {
    agent any
    parameters {
        string(name: 'COMMIT')
    }
    stages {
        stage('Rollback') {
            steps {
                script {
                    if (params.COMMIT == null) {
                        error('Please specify the COMMIT parameter')
                    }
                }
                sh """
                    oc start-build greeting-metrics \
                    --commit ${params.COMMIT} --follow --wait \
                    -n atoccz-metrics
                """
            }
        }
    }
}
