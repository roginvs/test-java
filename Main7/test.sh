set -e

timeout 30 ./run.sh &

sleep 3

curl http://localhost:8080/index.html --header 'Host: spacerangers.gitlab.io' -v --fail > /dev/null