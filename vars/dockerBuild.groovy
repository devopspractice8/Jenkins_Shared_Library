def call(String appImage) {
    sh "docker build -t ${appImage} ."
}
