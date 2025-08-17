def call(String appName, String appImage, String appPort, String mongoName, String mongoUser, String mongoPass, String dockerNet) {
    sh """
        docker rm -f ${appName} || true
        docker run -d --name ${appName} \\
          --network ${dockerNet} \\
          -p ${appPort}:8080 \\
          -e MONGO_DB_HOSTNAME=${mongoName} \\
          -e MONGO_DB_USERNAME=${mongoUser} \\
          -e MONGO_DB_PASSWORD=${mongoPass} \\
          ${appImage}
    """
}
