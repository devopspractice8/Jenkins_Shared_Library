def call(String appImage, String ecrRepo, String awsRegion, String credentialsId) {
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: credentialsId]]) {
        sh """
            aws ecr describe-repositories --repository-names ${ecrRepo.split('/')[1]} --region ${awsRegion} || \
            aws ecr create-repository --repository-name ${ecrRepo.split('/')[1]} --region ${awsRegion}

            aws ecr get-login-password --region ${awsRegion} | docker login --username AWS --password-stdin ${ecrRepo.split(':')[0]}

            docker tag ${appImage} ${ecrRepo}:latest
            docker push ${ecrRepo}:latest
        """
    }
}
