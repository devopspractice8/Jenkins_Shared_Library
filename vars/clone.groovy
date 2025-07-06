def call(String url,String branch){
  echo "This is Cloning the Code"
  git url: "$(url)", branch: "$(branch)"
  echo "Code Cloning Successful"
}
