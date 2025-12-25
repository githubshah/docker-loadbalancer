minikube delete --all --purge

minikube start --memory=4096 --cpus=2

Create Ingress Controller
minikube addons enable ingress

install kubernetes dashboard service
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.7.0/aio/deploy/recommended.yaml

kubectl apply -f dashboard-admin.yaml -n kubernetes-dashboard
kubectl port-forward kubernetes-dashboard-8696f5f494-dxjp2 8443 -n kubernetes-dashboard

// get token for login
kubectl -n kubernetes-dashboard create token admin-user

kubectl apply -f dashboard-ingress.yaml

kubectl get ingress -n kubernetes-dashboard

echo 127.0.0.1 mydashboard.com | sudo tee -a /etc/hosts

access app via 
mydashboard.com











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
Kubectl get pods -n test
kubectl port-forward pod/map-deployment-86d964948f-4pbhw 8085:8081 -n test
