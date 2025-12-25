kubectl apply -f dashboard-ingress.yaml

kubectl get ingress -n kubernetes-dashboard

echo 127.0.0.1 mydashboard.com | sudo tee -a /etc/hosts

access app via 
mydashboard.com