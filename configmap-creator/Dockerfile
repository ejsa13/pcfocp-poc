FROM alpine
COPY *-configmap . 
COPY *-template.yaml .
RUN apk add curl openssl yq && \
    chmod u+x create-configmap && \
    chmod u+x refresh-configmap && \
    chmod u+x download-properties

     