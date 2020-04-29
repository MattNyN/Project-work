# Build
mvn clean package && docker build -t com.mycompany/pw-feira .

# RUN

docker rm -f pw-feira || true && docker run -d -p 8080:8080 -p 4848:4848 --name pw-feira com.mycompany/pw-feira 