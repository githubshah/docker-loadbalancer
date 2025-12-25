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