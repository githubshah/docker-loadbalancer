minikube delete --all --purge

minikube start --cpus=4 --memory=7168

# Add the repository
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

# Install the stack into a 'monitoring' namespace
helm install my-prometheus prometheus-community/kube-prometheus-stack \
--create-namespace \
--namespace monitoring

# To getting grafana admin password
kubectl get secret -n monitoring my-prometheus-grafana -o jsonpath="{.data.admin-user}" | base64 --decode ; echo
kubectl get secret -n monitoring my-prometheus-grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo

# Create a test namespace and deploy the sample application
kubectl apply -f namespace.yaml -n test
kubectl apply -f deployment-v1.yaml -n test
kubectl apply -f uber-monitor.yaml -n test