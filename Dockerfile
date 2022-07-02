FROM payara/server-full

WORKDIR /app

COPY . /app

EXPOSE 80

COPY backend-1.0-SNAPSHOT.war $DEPLOY_DIR
COPY frontend-1.0-SNAPSHOT.war $DEPLOY_DIR