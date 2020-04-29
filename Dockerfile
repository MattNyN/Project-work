FROM airhacks/glassfish
COPY ./target/pw-feira.war ${DEPLOYMENT_DIR}
