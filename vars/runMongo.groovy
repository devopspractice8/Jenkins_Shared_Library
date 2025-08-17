def call(String mongoName, String mongoVol, String dockerNet, String mongoUser, String mongoPass) {
    sh """
        docker network create ${dockerNet} || true
        docker volume create ${mongoVol} || true
        docker rm -f ${mongoName} || true
        docker run -d --name ${mongoName} \\
          --network ${dockerNet} \\
          -e MONGO_INITDB_ROOT_USERNAME=${mongoUser} \\
          -e MONGO_INITDB_ROOT_PASSWORD=${mongoPass} \\
          -v ${mongoVol}:/data/db \\
          mongo:6
    """
}
