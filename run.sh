cd ws-bank
docker container stop ws-bank
docker container rm ws-bank
mvn package
docker image build -t your_name/some-app-image ./
docker container run -d --network="host" --name ws-bank -it your_name/some-app-image