cd ws-bank
sudo docker container stop ws-bank
sudo docker container rm ws-bank
mvn package
sudo docker image build -t your_name/some-app-image ./
sudo docker container run -d --network="host" --name ws-bank -it your_name/some-app-image