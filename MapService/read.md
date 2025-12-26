minikube delete --all --purge

minikube start --memory=4096 --cpus=2

# Add the repository
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

# Install the stack into a 'monitoring' namespace
helm install my-prometheus prometheus-community/kube-prometheus-stack \
--create-namespace \
--namespace monitoring

kubectl port-forward svc/my-prometheus-grafana 3000:80 -n monitoring

kubectl port-forward svc/my-prometheus-kube-prometheus-prometheus 9090:9090 -n monitoring

for open node port service
kubectl patch svc my-prometheus-grafana -n monitoring -p '{"spec": {"type": "NodePort"}}'

for getting grafana admin password
kubectl get secret -n monitoring my-prometheus-grafana -o jsonpath="{.data.admin-user}" | base64 --decode ; echo
kubectl get secret -n monitoring my-prometheus-grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo