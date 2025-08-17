def call(String repoUrl = 'https://github.com/devopspractice8/Springboot-Mongo-Application.git', String branch = 'main') {
    git url: repoUrl, branch: branch
}
