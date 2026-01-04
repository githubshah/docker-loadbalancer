#while true; do curl -s -H "Host: map.com" http://localhost/map > /dev/null; sleep 0.2; done
for i in {1..10}; do curl -s -H "Host: map.com" http://localhost/map; echo ""; done


#for i in {1..10}; do curl -s -H "Host: map.com" http://localhost/map/v1/location?riderId1; echo ""; done
#while true; do curl -s -H "Host: map.com" http://localhost/v1/location?riderId=1 > /dev/null; sleep 0.2; done