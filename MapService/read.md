docker build -t map:1.0 .
Confirm docker images

kubectl apply -f namespace.yaml
Confirm kubectl get namespace

kubectl apply -f deployment.yaml
Confirm kubectl get deployment -n test

check pods up and running 'kubectl get pods -n test'
if facing ImagePullBackOff error
make sure image with tag should be present ‘docker images’
minikube image load map:1.0 --overwrite
containers:
- name: map-container
  image: map:1.0
  imagePullPolicy: Never

Redeploy deployment 'kubectl delete deployment map-deployment -n test'
Redeploy deployment 'kubectl apply deployment map-deployment -n test'

If All good then test app
Kubectl get service -n test

kubectl get endpoints map-service -n test
in this case localhost bind with the node port
http://localhost:30081/map