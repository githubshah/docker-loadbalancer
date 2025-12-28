docker build -t map:1.0 .
Confirm docker images

kubectl apply -f https://projectcontour.io/quickstart/contour.yaml

kubectl apply -f namespace.yaml
Confirm kubectl get namespace

kubectl apply -f deployment.yaml
Confirm kubectl get deployment -n test

kubectl apply -f http-proxy.yaml

check pods up and running 'kubectl get pods -n test'
if facing ImagePullBackOff error 
make sure image with tag should be present ‘docker images’
minikube image load map:1.0 --overwrite
containers:
- name: map-container
  image: map:1.0
  imagePullPolicy: Never

If All good then test app
Kubectl get pods -n test
kubectl port-forward pod/map-deployment-86d964948f-4pbhw 8085:8081 -n test
